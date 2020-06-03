package hu.me.krz.haladojava.newsletter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

@Service
public class NewsletterSenderServiceImpl implements NewsletterSenderService, EmailService{

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    private Collection<String> subscriberList;
    private Collection<String> successfulAddresses = new ArrayList<String>();
    private Collection<String> failedAddresses = new ArrayList<String>();
    private String newsLetter;
    
    @Autowired
    private JavaMailSender emailSender;
    
    @Autowired
    private SimulatedNewsLetterService newsLetterService;
    
    @Autowired
    private SimulatedUserService userService;
	
	@Override
	public void sendNewsletter(Collection<String> addresses, String letterText) {
		// TODO Auto-generated method stub
		if(!(subscriberList != null && subscriberList.isEmpty() && newsLetter.isEmpty())) {
    		logger.info("Sending newsletters has begun...");
    		
    		for (String address : addresses) {
    			sendSimpleMessage(address, "Newsletter", letterText);
    		}
    		
            logger.info("Sending newsletters has finished.");
            
            
            if(failedAddresses.size() > 0) {
            	String errorMessage = "Letter was failed to be delivered to these addresses: ";
            	for (String address : failedAddresses) {
            		errorMessage+= "\n" + address;
				}
            	
            	logger.error(errorMessage);	
            }
            
            logger.info("Removing successful addresses.");
            userService.removeSuccessfulAddresses((List<String>) successfulAddresses);

    	}
    	else {
    		logger.error("Sending newsletter failed, subscriber list or newsletter might be empty. SubscriberList length: "
    				+ subscriberList.size() + " newsLetter length: " + newsLetter.length());
    	}
	}

	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		// TODO Auto-generated method stub
		 try {
	            SimpleMailMessage message = new SimpleMailMessage();
	            message.setTo(to);
	            message.setSubject(subject);
	            message.setText(text);

	            emailSender.send(message);
	            logger.info("Newsletter delivered to: " + to);
	            
	            successfulAddresses.add(to);
	        } catch (MailException exception) {
	            logger.error(exception.getMessage());
	            failedAddresses.add(to);
	        }
	}

	@Override
	public void sendNewsletter() {
		// TODO Auto-generated method stub
		initService();
		sendNewsletter(subscriberList, newsLetter);
		
	}

	@Override
	public void initService() {
		// TODO Auto-generated method stub
		this.newsLetter = newsLetterService.getNewsLetterToSend();
		this.subscriberList = userService.getUserList().stream().
				map(user -> user.getEmail()).collect(Collectors.toList());
		this.failedAddresses.clear();
	}
	
}
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

import java.util.Collection;

@Service
public class NewsletterJobService implements NewsletterService, EmailService{

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Getter
    @Setter
    private Collection<String> subscriberList;
    
    @Getter
    @Setter
    private String newsLetter;
    
    public void executeNewsletterJob() {

        logger.info("Sending newsletters has begun...");
        sendNewsletter(subscriberList, newsLetter);
        logger.info("Sending newsletters has finished...");

    }
    
    @Autowired
    public JavaMailSender emailSender;
	
	@Override
	public void sendNewsletter(Collection<String> addresses, String letterText) {
		// TODO Auto-generated method stub
		for (String address : addresses) {
			sendSimpleMessage(address, "Newsletter", letterText);
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
	        } catch (MailException exception) {
	            exception.printStackTrace();
	        }
	}
	
}
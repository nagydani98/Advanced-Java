package hu.me.krz.haladojava.newsletter.controller;

import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hu.me.krz.haladojava.newsletter.service.NewsletterJobService;
import hu.me.krz.haladojava.newsletter.service.SimulatedNewsLetterService;
import hu.me.krz.haladojava.newsletter.service.SimulatedUserService;

@Controller
public class NewsLetterSendingController {

	@Autowired
	private NewsletterJobService newsletterJobService;
	
	@Autowired
	private SimulatedNewsLetterService newsLetterService;
	
	@Autowired
	private SimulatedUserService userService;
	
	@PostConstruct
	private void initNewsLetterJobService(){
		newsletterJobService.setNewsLetter(newsLetterService.getNewsLetterToSend());
		newsletterJobService.setSubscriberList(userService.getUserList().stream().
				map(user -> user.getEmail()).collect(Collectors.toList()));
	}
}

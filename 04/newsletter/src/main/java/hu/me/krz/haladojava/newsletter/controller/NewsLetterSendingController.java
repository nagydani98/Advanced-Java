package hu.me.krz.haladojava.newsletter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.krz.haladojava.newsletter.service.NewsletterSenderService;

@RestController
public class NewsLetterSendingController {

	@Autowired
	private NewsletterSenderService newsletterJobService;
	
	@GetMapping("/sendNewsletters")
	public void sendNewsletter() {
		newsletterJobService.sendNewsletter();
	}
}

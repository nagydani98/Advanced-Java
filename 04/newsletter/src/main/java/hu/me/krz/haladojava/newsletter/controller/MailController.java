package hu.me.krz.haladojava.newsletter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.krz.haladojava.newsletter.service.EmailServiceImpl;

@RestController
public class MailController {
	
	@Autowired
	private EmailServiceImpl emailService;
	
	@RequestMapping(value = "/sendmail")
	public void sendMail() {
		emailService.sendSimpleMessage("n.dani9812@gmail.com", "Test", "Hello via email!");
	}
}

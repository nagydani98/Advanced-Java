package hu.me.krz.haladojava.newsletter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.me.krz.haladojava.newsletter.repository.NewsLetterRepository;

@Service
public class SimulatedNewsLetterServiceImpl implements SimulatedNewsLetterService{

	@Autowired
	NewsLetterRepository newsLetterRepository;
	
	public String getNewsLetterToSend() {
		return newsLetterRepository.getNewsLetterText();
	}
}

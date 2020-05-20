package hu.me.krz.haladojava.newsletter.service;

import org.springframework.stereotype.Service;

@Service
public class SimulatedNewsLetterService {

	public String getNewsLetterToSend() {
		return "Imagine this is the text of an actual newsletter.";
	}
}

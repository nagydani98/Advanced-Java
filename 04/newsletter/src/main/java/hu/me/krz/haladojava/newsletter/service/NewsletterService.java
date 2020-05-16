package hu.me.krz.haladojava.newsletter.service;

import java.util.Collection;

public interface NewsletterService {
		public void sendNewsletter(Collection<String> addresses, String letterText);
}

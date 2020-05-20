package hu.me.krz.haladojava.newsletter.service;

import java.util.Collection;

public interface NewsletterSenderService {
		public void sendNewsletter(Collection<String> addresses, String letterText);
}

package hu.me.krz.haladojava.newsletter.service;

public interface EmailService {
    void sendSimpleMessage(String to,
            String subject,
            String text);
}

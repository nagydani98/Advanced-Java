package hu.me.krz.haladojava.newsletter.mailservice;

public interface EmailService {
    void sendSimpleMessage(String to,
            String subject,
            String text);
}

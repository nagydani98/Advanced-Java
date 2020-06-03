package hu.me.krz.haladojava.newsletter.servicetests;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import hu.me.krz.haladojava.newsletter.data.User;
import hu.me.krz.haladojava.newsletter.service.NewsletterSenderServiceImpl;
import hu.me.krz.haladojava.newsletter.service.SimulatedNewsLetterServiceImpl;
import hu.me.krz.haladojava.newsletter.service.SimulatedUserServiceImpl;

@RunWith(SpringRunner.class)
public class NewsLetterSenderServiceImplTest {

	@TestConfiguration
	static class NewsLetterSenderServiceImplTestContextConfiguration {
		  
        @Bean
        public NewsletterSenderServiceImpl newsletterSenderService() {
            return new NewsletterSenderServiceImpl();
        }
    }
	
	@Autowired
	private NewsletterSenderServiceImpl newsletterSenderServiceImpl;
	
	@MockBean
	private SimulatedUserServiceImpl simulatedUserServiceImpl;
	
	@MockBean 
	private SimulatedNewsLetterServiceImpl simulatedNewsLetterServiceImpl;
	
	@MockBean
	JavaMailSender mailSender;
	
	private final static String TEST_ADDRESS = "testhingsdani@gmail.com";
	private final static String TEST_SUBJECT = "Test subject";
	private final static String TEST_LETTERTEXT = "Test example content of a newsletter";
	
	@Captor
	private ArgumentCaptor<SimpleMailMessage> simpleMsgCaptor;
	
	@Before
	public void setupMockServiceReturns() {
		when(simulatedUserServiceImpl.getUserList()).
		thenReturn(
		new ArrayList<User>(Arrays.asList(new User(0, "TestMan", "testthingsdani@gmail.com"))));
		
		when(simulatedNewsLetterServiceImpl.getNewsLetterToSend()).thenReturn("This is a test newsletter");
	}
	
	@Test
	public void testInitServiceMethod() {
		newsletterSenderServiceImpl.initService();
		verify(simulatedNewsLetterServiceImpl, times(1)).getNewsLetterToSend();
		verify(simulatedUserServiceImpl, times(1)).getUserList();
	}
	
	@Test
	public void testSendSimpleMessage() {
		newsletterSenderServiceImpl.sendSimpleMessage(TEST_ADDRESS, TEST_SUBJECT, TEST_LETTERTEXT);
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(TEST_ADDRESS);
        message.setSubject(TEST_SUBJECT);
        message.setText(TEST_LETTERTEXT);
		verify(mailSender, times(1)).send(simpleMsgCaptor.capture());
		assertTrue(message.equals(simpleMsgCaptor.getValue()));
	}
	
	@Test
	public void testSendSimpleMessageWithMailExcpetion() {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(TEST_ADDRESS);
        message.setSubject(TEST_SUBJECT);
        message.setText(TEST_LETTERTEXT);
		doThrow(
				MailSendException.class).
		when(mailSender).
		send(message);
		newsletterSenderServiceImpl.sendSimpleMessage(TEST_ADDRESS, TEST_SUBJECT, TEST_LETTERTEXT);
		
	}
	
	@Test
	public void testSendNewsLetterWithEmptySubscriberList() {
		newsletterSenderServiceImpl.sendNewsletter(
				new ArrayList<>(), TEST_LETTERTEXT);
		verify(mailSender, times(0)).send(any(MimeMessage.class));		
	}
	
	@Test
	public void testSendNewsLetterWithEmptyLetterText() {
		newsletterSenderServiceImpl.sendNewsletter(new ArrayList<>(Arrays.asList(TEST_ADDRESS)), "");
		verify(mailSender, times(0)).send(any(MimeMessage.class));		
	}
	
	@Test
	public void testNumberOfSentLettersMatchesAddresses() {
		List<String> addressList = new ArrayList<>(Arrays.asList(TEST_ADDRESS, TEST_ADDRESS, TEST_ADDRESS));
		newsletterSenderServiceImpl.sendNewsletter(addressList, TEST_LETTERTEXT);
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(TEST_ADDRESS);
        message.setSubject("Newsletter");
        message.setText(TEST_LETTERTEXT);
		verify(mailSender, times(3)).send(simpleMsgCaptor.capture());
		assertTrue(message.equals(simpleMsgCaptor.getValue()));
	}
	
	@Test
	public void testNoArgSendNewsLetter() {
		newsletterSenderServiceImpl.sendNewsletter();
		
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(simulatedUserServiceImpl.getUserList().get(0).getEmail());
        message.setSubject("Newsletter");
        message.setText(simulatedNewsLetterServiceImpl.getNewsLetterToSend());
		
		verify(mailSender, times(1)).send(simpleMsgCaptor.capture());
		assertTrue(message.equals(simpleMsgCaptor.getValue()));
	}
	
	
}

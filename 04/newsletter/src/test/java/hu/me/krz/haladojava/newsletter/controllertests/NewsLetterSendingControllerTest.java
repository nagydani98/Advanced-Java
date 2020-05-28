package hu.me.krz.haladojava.newsletter.controllertests;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import hu.me.krz.haladojava.newsletter.service.NewsletterSenderServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest
public class NewsLetterSendingControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private NewsletterSenderServiceImpl newsletterSenderServiceImpl;
	
	@Test
	public void testSendNewsLettersThoughRequest() throws Exception {
		mockmvc.perform(get("/sendNewsletters")).andExpect(status().isOk());
		verify(newsletterSenderServiceImpl, times(1)).sendNewsletter();
	}
}

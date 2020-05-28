package hu.me.krz.haladojava.newsletter.servicetests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import hu.me.krz.haladojava.newsletter.repository.NewsLetterRepository;
import hu.me.krz.haladojava.newsletter.service.SimulatedNewsLetterServiceImpl;

@RunWith(SpringRunner.class)
public class SimulateNewsletterServiceImplTest {
	@TestConfiguration
    static class SimulateNewsletterServiceImplTestContextConfiguration {
  
        @Bean
        public SimulatedNewsLetterServiceImpl newsletterService() {
            return new SimulatedNewsLetterServiceImpl();
        }
    }
	
	@Autowired
	private SimulatedNewsLetterServiceImpl simulatedNewsLetterServiceImpl;
	
	@MockBean
	private NewsLetterRepository newsLetterRepository;
	
	@Test
	public void testServiceGetNewsletterReturnsNull() {
		assertNull(simulatedNewsLetterServiceImpl.getNewsLetterToSend());
	}
}

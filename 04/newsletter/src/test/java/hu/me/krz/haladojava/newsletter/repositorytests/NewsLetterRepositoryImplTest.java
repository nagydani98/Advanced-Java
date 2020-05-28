package hu.me.krz.haladojava.newsletter.repositorytests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import hu.me.krz.haladojava.newsletter.repository.NewsLetterRepositoryImpl;

@RunWith(SpringRunner.class)
public class NewsLetterRepositoryImplTest {
	
	
	@Test
	public void testGetNewsletterText() {
		NewsLetterRepositoryImpl newsLetterRepositoryImpl = new NewsLetterRepositoryImpl();
		assertNotNull(newsLetterRepositoryImpl.getNewsLetterText());
	}
}

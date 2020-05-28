package hu.me.krz.haladojava.newsletter.repositorytests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import hu.me.krz.haladojava.newsletter.repository.UserRepositoryImpl;

@RunWith(SpringRunner.class)
public class UserRepositoryImplTest {
	
	@Test
	public void testGetUsers() {
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
		assertNotNull(userRepositoryImpl.getUsers());
		assertTrue(userRepositoryImpl.getUsers().size() > 0);
	}
}

package hu.me.krz.haladojava.newsletter.repositorytests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import hu.me.krz.haladojava.newsletter.data.User;
import hu.me.krz.haladojava.newsletter.repository.UserRepositoryImpl;

@RunWith(SpringRunner.class)
public class UserRepositoryImplTest {
	
	@Test
	public void testConstructor() {
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
		assertNotNull(userRepositoryImpl);
	}
	
	@Test
	public void testGetUsers() {
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
		assertNotNull(userRepositoryImpl.getUsers());
		assertTrue(userRepositoryImpl.getUsers().size() > 0);
	}
	
	@Test
	public void testRemoveUser(){
		UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
		User toRemove = userRepositoryImpl.getUsers().get(1);
		int previousSize = userRepositoryImpl.getUsers().size();
		
		assertTrue(userRepositoryImpl.getUsers().size() > 0);
		
		userRepositoryImpl.remove(toRemove);
		
		assertTrue(userRepositoryImpl.getUsers().size() == (previousSize - 1));
	}
}

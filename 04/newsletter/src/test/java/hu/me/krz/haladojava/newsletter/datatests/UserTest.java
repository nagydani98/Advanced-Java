package hu.me.krz.haladojava.newsletter.datatests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import hu.me.krz.haladojava.newsletter.data.User;

@RunWith(SpringRunner.class)
public class UserTest {
	private final long TEST_ID = 1;
	private final String TEST_NAME = "John Doe";
	private final String TEST_EMAIL = "testhingsdani@gmail.com";
	
	@Test
	public void testUserConstructorReturnNotNull() {
		User user = new User(TEST_ID, TEST_NAME, TEST_EMAIL);
		assertNotNull(user);
	}
	
	@Test
	public void testUserConstructor() {
		User user = new User(TEST_ID, TEST_NAME, TEST_EMAIL);
		assertEquals(TEST_ID, user.getId());
		assertEquals(TEST_NAME, user.getName());
		assertEquals(TEST_EMAIL, user.getEmail());
	}
	
	@Test
	public void testUserSetter() {
		User user = new User(3, "", "");
		
		user.setId(TEST_ID);
		user.setName(TEST_NAME);
		user.setEmail(TEST_EMAIL);
		
		assertEquals(TEST_ID, user.getId());
		assertEquals(TEST_NAME, user.getName());
		assertEquals(TEST_EMAIL, user.getEmail());
	}
	
	@Test
	public void testToString() {
		User user = new User(TEST_ID, TEST_NAME, TEST_EMAIL);
		assertNotNull(user.toString());
	}
	
	@Test
	public void testHashCode() {
		User user = new User(TEST_ID, TEST_NAME, TEST_EMAIL);
		assertNotNull(user.hashCode());
	}
	
	@Test
	public void testEquals() {
		User user1 = new User(TEST_ID, TEST_NAME, TEST_EMAIL);
		User user2 = new User(TEST_ID, TEST_NAME, TEST_EMAIL);
		User user3 = new User(3, TEST_NAME, TEST_EMAIL);
		
		assertTrue(user1.equals(user2));
		assertFalse(user1.equals(user3));
	}
}

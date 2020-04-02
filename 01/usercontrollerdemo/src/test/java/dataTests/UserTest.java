package dataTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.User;
import data.UserDto;

class UserTest {

	@Test
	void testUserNameArgsConstructor() {
		String name = "a";

		
		User user = new User(name);
		
		assertEquals(name, user.getName());
				
	}
	
	@Test
	void testUserNameAndNeptunConstructor() {
		String name = "a";
		String neptun ="b";

		User user = new User(name, neptun);
		
		assertEquals(name, user.getName());
		assertEquals(neptun, user.getNeptun());
				
	}
	
	@Test
	void testUserNameAndEnabledConstructor() {
		String name = "a";
		boolean enabled = true;

		User user = new User(name, enabled);
		
		assertEquals(name, user.getName());
		assertEquals(enabled, user.isEnabled());
				
	}
	
	@Test
	void testUserAllArgsConstructor() {
		String name = "a";
		String neptun ="b";
		boolean enabled = true;
		
		User user = new User(name, neptun, enabled);
		
		assertEquals(name, user.getName());
		assertEquals(neptun, user.getNeptun());
		assertEquals(enabled, user.isEnabled());
				
	}
	
	@Test
	void testNoArgsConstructor() {
		
		User user = new User();
		
		assertNull(user.getName());
		assertNull(user.getNeptun());
		assertNotNull(user.isEnabled());
				
	}

	@Test
	void testBuilder() {
		String name = "a";
		String neptun ="b";
		boolean enabled = true;
		User user = User.builder().name(name).neptun(neptun).enabled(enabled).build();
		
		assertEquals(name, user.getName());
		assertEquals(neptun, user.getNeptun());
		assertEquals(enabled, user.isEnabled());
				
	}
	
	@Test
	void testGetterSetter() {
		String name = "a";
		String neptun ="b";
		boolean enabled = true;
		User user = User.builder().name(name).neptun(neptun).enabled(enabled).build();
		
		assertEquals(name, user.getName());
		assertEquals(neptun, user.getNeptun());
		assertEquals(enabled, user.isEnabled());
		
		String name2 = "aa";
		String neptun2 ="bb";
		boolean enabled2 = false;
		
		user.setName(name2);
		user.setNeptun(neptun2);
		user.setEnabled(enabled2);
		
		assertEquals(name2, user.getName());
		assertEquals(neptun2, user.getNeptun());
		assertEquals(enabled2, user.isEnabled());
				
	}
	
	@Test
	void TestToString(){
		String name = "a";
		User user = new User(name);
		
		assertNotNull(user.toString());
	}
	
	@Test
	void TestHashCode(){
		String name = "a";
		User user = new User(name);
		
		assertNotNull(user.hashCode());
	}
	
	@Test
	void TestEquals(){
		String name = "a";
		String name2 = "b";
		User usr1 = new User(name);
		User usr2 = new User(name);
		User usr3 = new User(name2);
		
		assertTrue(usr1.equals(usr2));
		assertFalse(usr1.equals(usr3));
	}
}

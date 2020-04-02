package dataTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.UserDto;

class userDtoTest {

	@Test
	void testNoArgsCosntructor() {
		UserDto usrdto = new UserDto();
		
		assertNotNull(usrdto);
		assertNull(usrdto.getName());
	}
	
	@Test
	void testAllArgsCosntructor() {
		String name = "a";
		UserDto usrdto = new UserDto(name);
		
		assertNotNull(usrdto);
		assertEquals(usrdto.getName(), name);
	}
	
	@Test
	void TestSetter(){
		String name = "a";
		String name2 = "ab";
		UserDto usrdto = new UserDto(name);
		
		assertEquals(usrdto.getName(), name);
		usrdto.setName(name2);
		
		
		assertEquals(usrdto.getName(), name2);
	}
	
	@Test
	void TestToString(){
		String name = "a";
		UserDto usrdto = new UserDto(name);
		
		assertNotNull(usrdto.toString());
	}
	
	@Test
	void TestHashCode(){
		String name = "a";
		UserDto usrdto = new UserDto(name);
		
		assertNotNull(usrdto.hashCode());
	}
	
	@Test
	void TestEquals(){
		String name = "a";
		String name2 = "b";
		UserDto usrdto = new UserDto(name);
		UserDto usrdto2 = new UserDto(name);
		UserDto usrdto3 = new UserDto(name2);
		
		assertTrue(usrdto.equals(usrdto2));
		assertFalse(usrdto.equals(usrdto3));
	}

}

package validatorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import data.User;
import validators.SpaceValidator;

class SpaceValidatorTest {

	SpaceValidator sv = new SpaceValidator();
	
	@Test
	void testIsValidWithoutParam() {
		assertThrows(NullPointerException.class, () -> sv.isValid(null));
		
	}

	@Test
	void testIsValidWithSpacedParam() {
		User user = mock(User.class);
		when(user.getName()).thenReturn(" ");
		assertFalse(sv.isValid(user));
	}
	
	@Test
	void testIsValidWithNoSpaceParam() {
		User user = mock(User.class);
		when(user.getName()).thenReturn("bla");
		assertTrue(sv.isValid(user));
	}
}

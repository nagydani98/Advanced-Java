package validatorTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import data.User;
import validators.LengthValidator;

class LengthValidatorTest {

	LengthValidator lv = new LengthValidator();
	
	@Test
	void testIsValidWithoutParam() {
		assertThrows(NullPointerException.class, () -> lv.isValid(null));
		
	}

	@Test
	void testIsValidWithSpacedParam() {
		User user = mock(User.class);
		when(user.getName()).thenReturn("bla");
		assertFalse(lv.isValid(user));
	}
	
	@Test
	void testIsValidWithNoSpaceParam() {
		User user = mock(User.class);
		when(user.getName()).thenReturn("blabla");
		assertTrue(lv.isValid(user));
	}

}

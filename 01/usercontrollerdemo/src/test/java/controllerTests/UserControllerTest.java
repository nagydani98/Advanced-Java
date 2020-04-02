package controllerTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import controllers.UserController;
import data.NeptunGenerator;
import data.User;
import data.UserDto;
import data.UserService;

@RunWith(MockitoJUnitRunner.class)
class UserControllerTest {

	@Mock
	UserService userService;
	
	@Mock
	NeptunGenerator neptunGen;
	
	@InjectMocks
	UserController userc = new UserController(userService, neptunGen);
	
	@Mock
	UserDto userDto;
	
	@Mock
	User user;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testSaveWithNullInput() {
		assertThrows(NullPointerException.class, () -> userc.save(null));
	}
	
	@Test
	void testThatSaveRuns() {
		
		
		userc.save(userDto);
		
		verify(userService, times(1)).saveUser(Mockito.any(User.class));
		
	}

}

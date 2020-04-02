package dataTests;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import data.UserModify;
import data.UserServiceImpl;
import validators.Validator;

@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

	@Mock
	UserModify repo;
	@Mock
	List<Validator> validators;
	
	@InjectMocks
	UserServiceImpl usrService = new UserServiceImpl(repo, validators);
	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testConstructor() {
		assertNotNull(usrService);
	}

}

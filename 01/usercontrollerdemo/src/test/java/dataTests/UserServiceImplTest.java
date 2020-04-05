package dataTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import validators.SpaceValidator;
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
	
	@Test
	void testSaveWithValidTrue(){
		SpaceValidator sv = mock(SpaceValidator.class);
		when(sv.isValid(null)).thenReturn(true);
		List<Validator> validators = new ArrayList<Validator>();
		validators.add(sv);
		
		usrService = new UserServiceImpl(repo, validators);
		
		usrService.saveUser(null);
		
		//saveUser validates and calls repo.save
		//using mock, validator will always return true
		//we only have to check if the save() method of repo is called
		verify(repo, times(1)).save(null);
	}
	
	@Test
	void testSaveWithValidFalse(){
		SpaceValidator sv = mock(SpaceValidator.class);
		when(sv.isValid(null)).thenReturn(false);
		List<Validator> validators = new ArrayList<Validator>();
		validators.add(sv);
		
		usrService = new UserServiceImpl(repo, validators);
		
		usrService.saveUser(null);
		
		verify(repo, times(0)).save(null);
	}

}

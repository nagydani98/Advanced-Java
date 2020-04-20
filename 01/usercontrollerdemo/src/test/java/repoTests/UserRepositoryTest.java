package repoTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import data.User;
import repositories.UserRepository;

@RunWith(MockitoJUnitRunner.class)
class UserRepositoryTest {

	UserRepository repo = new UserRepository();
	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testEmppyRepoReturnsNull() {
		assertEquals(0, repo.findAll().size());
		assertEquals(0, repo.findByEnabledIsTrue().size());
		assertNull(repo.getByNeptun(""));
	}

	@Test
	void testSave() {
		User usr = mock(User.class);
		when(usr.getName()).thenReturn("miska");
		repo.save(usr);
		
		assertEquals(repo.findAll().size(), 1);
		assertEquals(repo.findAll().get(0), usr);
		
	}
	
	@Test
	void testGetByNeptun() {
		User usr = mock(User.class);
		when(usr.getName()).thenReturn("miska");
		when(usr.getNeptun()).thenReturn("11");
		repo.save(usr);
		
		assertEquals(usr, repo.getByNeptun("11"));
	}
	
	@Test
	void testFindByEnabled() {
		User usr1 = mock(User.class);
		when(usr1.getName()).thenReturn("miska");
		User usr2 = mock(User.class);
		when(usr2.getName()).thenReturn("miska");
		
		when(usr1.isEnabled()).thenReturn(true);
		when(usr2.isEnabled()).thenReturn(false);
		
		
		repo.save(usr1);
		repo.save(usr2);
		
		assertEquals(usr1, repo.findByEnabledIsTrue().get(0));
		assertEquals(1, repo.findByEnabledIsTrue().size());
	}
}

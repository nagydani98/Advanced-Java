package hu.me.krz.haladojava.newsletter.servicetests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import hu.me.krz.haladojava.newsletter.data.User;
import hu.me.krz.haladojava.newsletter.repository.UserRepository;
import hu.me.krz.haladojava.newsletter.repository.UserRepositoryImpl;
import hu.me.krz.haladojava.newsletter.service.SimulatedUserServiceImpl;

@RunWith(SpringRunner.class)
public class SimulatedUserServiceImplTest {

	@TestConfiguration
    static class SimulatedUserServiceImplTestContextConfiguration {
  
        @Bean
        public SimulatedUserServiceImpl userService() {
            return new SimulatedUserServiceImpl();
        }
        
        @Bean
        public UserRepository userRepository() {
        	return new UserRepositoryImpl();
        }
    }
	
	@Autowired
	private SimulatedUserServiceImpl simulatedUserServiceImpl;
	
	@Test
	public void testServiceGetUsersReturnsNotNull() {
		assertNotNull(simulatedUserServiceImpl.getUserList());
		assertNotNull(simulatedUserServiceImpl.getUserList().get(0));
	}
	
	@Test
	public void testRemoveSuccessfulAddresses() {
		List<String> addressToRemove = new ArrayList<>(Arrays.asList("testthingsdani@gmail.com"));
		assertTrue(simulatedUserServiceImpl.getUserList().size() > 0);
		
		int previous = simulatedUserServiceImpl.getUserList().size();
		
		simulatedUserServiceImpl.removeSuccessfulAddresses(addressToRemove);
		
		assertTrue(simulatedUserServiceImpl.getUserList().size() < previous);
	}
}

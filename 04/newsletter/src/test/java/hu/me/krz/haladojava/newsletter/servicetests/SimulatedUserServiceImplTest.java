package hu.me.krz.haladojava.newsletter.servicetests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import hu.me.krz.haladojava.newsletter.repository.UserRepository;
import hu.me.krz.haladojava.newsletter.service.SimulatedUserServiceImpl;

@RunWith(SpringRunner.class)
public class SimulatedUserServiceImplTest {

	@TestConfiguration
    static class SimulatedUserServiceImplTestContextConfiguration {
  
        @Bean
        public SimulatedUserServiceImpl userService() {
            return new SimulatedUserServiceImpl();
        }
    }
	
	@Autowired
	private SimulatedUserServiceImpl simulatedUserServiceImpl;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void testServiceGetUsersReturnsNotNull() {
		assertNotNull(simulatedUserServiceImpl.getUserList());
	}
}

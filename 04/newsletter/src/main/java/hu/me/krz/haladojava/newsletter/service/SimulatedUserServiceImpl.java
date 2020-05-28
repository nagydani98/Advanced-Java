package hu.me.krz.haladojava.newsletter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.me.krz.haladojava.newsletter.data.User;
import hu.me.krz.haladojava.newsletter.repository.UserRepository;

@Service
public class SimulatedUserServiceImpl implements SimulatedUserService{

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUserList(){	
		return userRepository.getUsers();
	}
}

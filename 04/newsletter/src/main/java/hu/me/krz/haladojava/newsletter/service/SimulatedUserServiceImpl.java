package hu.me.krz.haladojava.newsletter.service;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public void removeSuccessfulAddresses(List<String> emailAddresses) {
		//emailAddresses.stream().map(address -> address.equals(userRepository.getUsers().forEach(user -> user.getEmail())));
		List<User> successful = userRepository.getUsers().stream().
				filter(user -> emailAddresses.contains(user.getEmail())).collect(Collectors.toList());
		
		successful.forEach(user -> userRepository.remove(user));
	}
}

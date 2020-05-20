package hu.me.krz.haladojava.newsletter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hu.me.krz.haladojava.newsletter.data.User;

@Service
public class SimulatedUserService {

	private List<User> userList = new ArrayList<User>();
	
	public List<User> getUserList(){
		
		for (int i = 0; i < 3; i++) {
			userList.add(new User(i + 1, "Guy " + i, "testthingsdani@gmail.com"));
		}
		
		return userList;
	}
}

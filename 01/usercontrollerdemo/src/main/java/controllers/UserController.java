package controllers;

import java.util.ArrayList;
import java.util.List;

import data.User;

public class UserController {
	List<User> userList = new ArrayList<User>();
	
	public void registerUser(String name) {
		if(!name.contains(" ")) {
			User user = new User(name);
			userList.add(user);
			
			System.out.println("Registered " + user);
		}
		else {
			System.err.println("Error, username cannot contain spaces!");
		}
		
		
	}
}

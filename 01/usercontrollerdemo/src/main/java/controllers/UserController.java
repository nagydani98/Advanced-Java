package controllers;

import java.util.ArrayList;
import java.util.List;

import data.User;
import repositories.UserRepository;

public class UserController {
	
	UserRepository repository = new UserRepository();
	public void save(User user) {
		if(!user.getName().contains(" ") && user.getName().length() > 5) {
			
			repository.save(user);
			
		}
		else {
			System.err.println("Error, username cannot contain spaces!");
		}
		
		
	}
}

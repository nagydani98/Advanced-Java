package controllers;

import java.util.ArrayList;
import java.util.List;


import data.User;
import repositories.UserRepository;
import validators.Validator;

public class UserController {
	
	UserRepository repository;
	List<Validator> validators;
	
	
	public UserController(UserRepository repository, List<Validator> validators) {
		super();
		this.repository = repository;
		this.validators = validators;
	}

	public void save(User user) {
		if(!user.getName().contains(" ") && user.getName().length() > 5) {
			
			if(isValid(user)) {
				repository.save(user);
			}
			
			
		}
		else {
			System.err.println("Error, username cannot contain spaces!");
		}
		
		
	}
	
	private boolean isValid(User user) {
		boolean isValid = true;
		for (Validator validator : validators) {
			if(!validator.isValid(user)) {
				isValid = false;
			}
		}
		return isValid;
	}
}

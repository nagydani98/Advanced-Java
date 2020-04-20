package data;

import java.util.List;

import validators.Validator;

public class UserServiceImpl implements UserService{
	UserModify repository;
	List<Validator> validators;
	
	
	public UserServiceImpl(UserModify repository, List<Validator> validators) {
		super();
		this.repository = repository;
		this.validators = validators;
	}


	public void saveUser(User user) {
		// TODO Auto-generated method stub
		if(isValid(user)) {
			repository.save(user);
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

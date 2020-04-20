package validators;

import data.User;

public class LengthValidator implements Validator {

	public boolean isValid(User user) {
		// TODO Auto-generated method stub
		return user.getName().length() > 5;
	}

}

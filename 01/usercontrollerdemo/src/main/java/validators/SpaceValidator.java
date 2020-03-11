package validators;

import data.User;

public class SpaceValidator implements Validator{

	public boolean isValid(User user) {
		// TODO Auto-generated method stub
		return !user.getName().contains(" ");
	}

}

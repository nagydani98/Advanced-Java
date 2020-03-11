package repositories;

import java.util.ArrayList;
import java.util.List;

import data.User;
import data.UserModify;

public class UserRepository implements UserModify{
	
	private List<User> userList = new ArrayList<User>();
	public void save(User user) {
		if(!user.getName().contains(" ")) {
			userList.add(user);
			System.out.println("User saved: " + user.getName());
		}
		
	}
	
	public User getByNeptun(String neptunCode) {
		User found = null;
		
		for (User user : userList) {
			if(user.getNeptun().equals(neptunCode)) {
				found = user;
			}
		}
		return found;
	}
	
	public List<User> findAll(){
		return userList;
	}
	
	public List<User> findByEnabledIsTrue(){
		List<User> result = new ArrayList();
		for (User user : userList) {
			if(user.isEnabled()) {
				result.add(user);
			}
		}
		return result;
	}
}

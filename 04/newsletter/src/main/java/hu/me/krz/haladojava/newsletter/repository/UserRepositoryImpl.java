package hu.me.krz.haladojava.newsletter.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import hu.me.krz.haladojava.newsletter.data.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private List<User> userList = new ArrayList<User>();
	
	public UserRepositoryImpl() {
		for (int i = 0; i < 3; i++) {
			userList.add(new User(i + 1, "Guy " + i, "testthingsdani@gmail.com"));
		}
	}
	
	@Override
	public List<User> getUsers() {
		return userList;
	}

	@Override
	public void remove(User user) {
		userList.remove(user);
	}

}

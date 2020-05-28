package hu.me.krz.haladojava.newsletter.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import hu.me.krz.haladojava.newsletter.data.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private List<User> userList = new ArrayList<User>();
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			userList.add(new User(i + 1, "Guy " + i, "testthingsdani@gmail.com"));
		}	
		userList.add(new User(4, "Guy 4", "invalid"));
		return userList;
	}

}

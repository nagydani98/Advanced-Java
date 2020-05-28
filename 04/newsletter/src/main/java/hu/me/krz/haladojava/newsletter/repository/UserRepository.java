package hu.me.krz.haladojava.newsletter.repository;

import java.util.List;

import hu.me.krz.haladojava.newsletter.data.User;

public interface UserRepository {
	public List<User> getUsers();
}

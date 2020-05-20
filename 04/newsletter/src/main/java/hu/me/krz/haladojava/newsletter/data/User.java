package hu.me.krz.haladojava.newsletter.data;

import lombok.Data;

@Data
public class User {
	private long id;
	private String name;
	private String email;
	
	public User(long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	
}

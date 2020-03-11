package data;

import lombok.Data;

@Data
public class User {
	private String name;

	
	
	public User(String name) {
		super();
		this.name = name;
	}



	public User() {
		super();
	}
	
	
}

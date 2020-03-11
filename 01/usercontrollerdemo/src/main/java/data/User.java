package data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
	private String name;
	private String neptun;
	private boolean enabled;
	
	
	public User(String name) {
		super();
		this.name = name;
	}



	public User() {
		super();
	}



	public User(String name, String neptun) {
		super();
		this.name = name;
		this.neptun = neptun;
	}



	public User(String name, String neptun, boolean enabled) {
		super();
		this.name = name;
		this.neptun = neptun;
		this.enabled = enabled;
	}
	
	
}

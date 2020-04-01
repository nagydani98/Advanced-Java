package data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	private String name;
	private String neptun;
	private boolean enabled;
	
	
	public User(String name) {
		super();
		this.name = name;
	}

	public User(String name, String neptun) {
		super();
		this.name = name;
		this.neptun = neptun;
	}
	
	public User(String name, boolean enabled) {
		this.name = name;
		this.enabled = enabled;
	}

	
}

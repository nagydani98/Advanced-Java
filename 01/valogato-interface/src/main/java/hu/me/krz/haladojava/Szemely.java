package hu.me.krz.haladojava;

import lombok.Data;

@Data
public abstract class Szemely implements IValogato{
	private String name;
	private int age;
	
	public Szemely(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
}

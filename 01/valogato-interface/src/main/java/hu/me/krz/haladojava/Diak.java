package hu.me.krz.haladojava;

import lombok.Data;

@Data
public class Diak extends Szemely implements IValogato{
	private int puska;
	
	public Diak(String name, int age, int puska) {
		super(name, age);
		this.puska = puska;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean joAlanyE() {
		// TODO Auto-generated method stub
		return puska <= 0;
	}

	@Override
	public String toString() {
		return "Diak [puska=" + puska + ", getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}

	
}

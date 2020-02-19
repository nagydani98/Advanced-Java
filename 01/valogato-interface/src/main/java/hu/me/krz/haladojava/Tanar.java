package hu.me.krz.haladojava;

import lombok.Data;

@Data
public class Tanar extends Szemely implements IValogato{

	private float avg;
	public Tanar(String name, int age) {
		super(name, age);
		avg = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean joAlanyE() {
		// TODO Auto-generated method stub
		return (getAge() < 30 && avg > 4);
	}

}

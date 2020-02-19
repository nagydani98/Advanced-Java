package hu.me.krz.haladojava;

import lombok.Data;

@Data
public class Tanulo {
	protected final String nev;
	protected int penz;
	
	private static int tanulok;
	
	public Tanulo(String nev, int penz) {
		this.nev = nev;
		this.penz = penz;
		
		tanulok++;
	}
	
	public Tanulo(String nev) {
		this(nev, 10000);
	}
	
	public static int osszestanulo() {
		return tanulok;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		tanulok--;
		super.finalize();
	}

	@Override
	public String toString() {
		return "Tanuló: " + nev + penz + "Ft";
	}
	
	public boolean fogyaszt(int amount) {
		if((penz -= amount) > 0) {
			return false;
		}
		return true;
	}
	
	
	
	
}

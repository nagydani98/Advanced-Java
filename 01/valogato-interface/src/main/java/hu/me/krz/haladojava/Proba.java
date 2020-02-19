package hu.me.krz.haladojava;

import java.util.Arrays;

public class Proba {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length > 1) {
			System.err.println("There is more than one argument!");
			System.exit(-1);
		}
		int param = 0;
		try {
			param = Integer.parseInt(args[0]);
			Szemely[] skacok = new Diak[param];
			for (int i = 0; i < skacok.length; i++) {
				skacok[i] = new Diak("skac", genNumBetween(10, 20), genNumBetween(0, 10));
				
				if(skacok[i].joAlanyE()) {
					System.out.println(skacok[i]);			
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

public static int genNumBetween(int lbound, int ubound) {
	return (int) (Math.random() * (ubound - lbound + 1) + lbound);
}
}

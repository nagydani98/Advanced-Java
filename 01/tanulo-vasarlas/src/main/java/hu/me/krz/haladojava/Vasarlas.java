package hu.me.krz.haladojava;

import java.security.GeneralSecurityException;
import java.util.ArrayList;

public class Vasarlas {

	
	public static void main( String[] args )
    {
		ArrayList<Tanulo> tanulok = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
			tanulok.add(new Tanulo("bob" + i));
		}
        
        for (int i = 0; i < 6; i++) {
			int sum = 0;
        	for (Tanulo tanulo : tanulok) {
				if(tanulo.fogyaszt(genNumBetween(1500, 3000))) {
					tanulok.remove(tanulo);
				}
				sum+= tanulo.getPenz();
			}
        	System.out.println(sum / Tanulo.osszestanulo());
		}
        
        System.out.println("Maradt tanulok: " + Tanulo.osszestanulo());
        
        for (Tanulo tanulo : tanulok) {
			System.out.println(tanulo);
		}
    }
	
	public static int genNumBetween(int lbound, int ubound) {
		return (int) (Math.random() * (ubound - lbound + 1) + lbound);
	}
}

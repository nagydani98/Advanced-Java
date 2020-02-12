package hu.me.krz.haladojava;

public class Proba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length > 1) {
			System.exit(-1);
		}
		int param = 0;
		try {
			param = Integer.parseInt(args[0]);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

import controllers.UserController;
import usercontrollerdemo.io.ConsoleReader;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Type in a name with at least 6 characters and no space:");
		String name = ConsoleReader.readStringBetweenLength(6, Integer.MAX_VALUE);
		
		UserController ctrler = new UserController();
		ctrler.registerUser(name);
	}

}

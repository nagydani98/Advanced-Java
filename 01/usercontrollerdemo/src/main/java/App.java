import controllers.UserController;
import data.User;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserController controller = new UserController();
		controller.save(new User("Lacoka", "GGZ56", true));
		controller.save(new User("Bazsika", "GoZ56", true));
		controller.save(new User("Ferike", "GGp56", true));
	}

}

import java.util.ArrayList;
import java.util.List;

import controllers.UserController;
import data.User;
import repositories.UserRepository;
import validators.LengthValidator;
import validators.SpaceValidator;
import validators.Validator;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserRepository repository = new UserRepository();
		List<Validator> validators = new ArrayList<Validator>();
		validators.add(new SpaceValidator());
		validators.add(new LengthValidator());
		UserController controller = new UserController();
		controller.save(new User("Lacoka", "GGZ56", true));
		controller.save(new User("Bazsika", "GoZ56", true));
		controller.save(new User("Ferike", "GGp56", true));
	}

}

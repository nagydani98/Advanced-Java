import java.util.ArrayList;
import java.util.List;

import controllers.UserController;
import data.NeptunGenerator;
import data.User;
import data.UserDto;
import data.UserService;
import data.UserServiceImpl;
import repositories.UserRepository;
import validators.LengthValidator;
import validators.SpaceValidator;
import validators.Validator;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 UserRepository useRepository = new UserRepository();
	        List<Validator> validators = new ArrayList<Validator>();
	        validators.add(new LengthValidator());
	        validators.add(new SpaceValidator());
	        UserService userService = new UserServiceImpl(
	                useRepository, validators
	        );

	        UserController userController = new UserController(
	                userService, new NeptunGenerator()
	        );


	        userController.save(new UserDto(" vanBenneSpace"));
	        userController.save(new UserDto("rovid"));
	        userController.save(new UserDto("nagyonjo"));
	}

}

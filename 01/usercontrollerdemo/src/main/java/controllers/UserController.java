package controllers;

import java.util.ArrayList;
import java.util.List;

import data.NeptunGenerator;
import data.User;
import data.UserDto;
import data.UserModify;
import data.UserService;
import repositories.UserRepository;
import validators.Validator;

public class UserController {
	
	UserService userService;
    NeptunGenerator neptunCodeGenerator;

    public UserController(UserService userService, NeptunGenerator neptunCodeGenerator) {
        this.userService = userService;
        this.neptunCodeGenerator = neptunCodeGenerator;
    }

    public void save(UserDto userDto) {
        userService.saveUser(new User(userDto.getName(), 
                String.format("neptun %d", neptunCodeGenerator.getNextCounter()), true));
    }
	
	
}

package bank.p0redux.controller;

import java.util.List;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.p0redux.models.User;
import bank.p0redux.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {


	@Autowired
	private UserService userS;
	

	public UserController(UserService userS) {
		this.userS=userS;

	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userS.getAllUsers();
	}


	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userS.getUserById(id);
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User u) {
		
		return userS.createUser(u);
	}
}

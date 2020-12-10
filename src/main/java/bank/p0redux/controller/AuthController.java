package bank.p0redux.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.p0redux.models.Customer;
import bank.p0redux.models.User;
import bank.p0redux.service.CustomerService;
import bank.p0redux.service.UserService;

@RequestMapping("/api")
@RestController
@CrossOrigin
public class AuthController {

	@Autowired
	private UserService userS;
	@Autowired
	private CustomerService custS;
	public AuthController(UserService userS, CustomerService custS) {
		this.userS=userS;
		this.custS=custS;
	}
	
	@PostMapping("/registerUser")
	public User createUser(@RequestBody User u) {
		return userS.createUser(u);
	}
	
	@PostMapping("/registerCustomer")
	public Customer createCustomer(@RequestBody Customer c) {
		Customer cust = custS.createCustomer(c);
		User user = cust.getMyUser();

		user.setMyCustomer(cust);
		userS.updateUser(user);
		
		return cust;
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User u) {
		User user = userS.findUserByUsername(u.getUsername());
		if(user==null) {
			return new User("Invalid Username", "Invalid Password", -1, null, null);
		} else {
			if(!u.getPassword().equals(user.getPassword())) {
				user.setPassword("Invalid Password");
			}
		}
		return user;
	}

}

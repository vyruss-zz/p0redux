package bank.p0redux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import bank.p0redux.models.Customer;

import bank.p0redux.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {


	@Autowired
	private CustomerService custS;

	public CustomerController(CustomerService custS) {

		this.custS=custS;

	}

	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return custS.getAllCustomers();
	}
	

}

package bank.p0redux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.p0redux.models.Customer;
import bank.p0redux.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo custR;
	
	public CustomerService(CustomerRepo custR) {
		this.custR=custR;
	}
	
	public List<Customer> getAllCustomers() {
		return custR.findAll();
	}
	
	public Customer createCustomer(Customer cust) {
		return custR.save(cust);
	}
	
	public Customer updateCustomer(Customer cust) {
		return custR.save(cust);
	}
}

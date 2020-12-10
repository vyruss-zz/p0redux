package bank.p0redux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.p0redux.models.Employee;

import bank.p0redux.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService empS;
	
	public EmployeeController(EmployeeService empS) {

		this.empS=empS;
	}
	

	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return empS.getAllEmployees();
	}
}

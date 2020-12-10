package bank.p0redux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.p0redux.models.Employee;
import bank.p0redux.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empR;
	
	public EmployeeService(EmployeeRepo empR) {
		this.empR = empR;
	}
	
	public List<Employee> getAllEmployees() {
		return empR.findAll();
	}
}

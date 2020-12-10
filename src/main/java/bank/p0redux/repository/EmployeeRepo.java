package bank.p0redux.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bank.p0redux.models.Employee;
@Repository
@Transactional
public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	public List<Employee> findAll();
}

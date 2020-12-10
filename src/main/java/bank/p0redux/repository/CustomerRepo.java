package bank.p0redux.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bank.p0redux.models.Customer;

@Repository
@Transactional
public interface CustomerRepo extends CrudRepository<Customer, Integer>{
	public List<Customer> findAll();
	public Customer save(Customer cust);
}

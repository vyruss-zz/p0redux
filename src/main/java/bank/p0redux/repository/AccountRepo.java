package bank.p0redux.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bank.p0redux.models.Account;

@Repository
@Transactional
public interface AccountRepo extends CrudRepository<Account, Integer>{
	public List<Account> findAll();
	public Account findByAccountId(int id);
}

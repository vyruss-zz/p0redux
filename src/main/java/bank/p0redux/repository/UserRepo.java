package bank.p0redux.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bank.p0redux.models.User;

@Repository
@Transactional
public interface UserRepo extends CrudRepository<User, Integer> {
	public List<User> findAll();
	public User findByUserId(int id);
	public User save(User user);
	public User findByUsername(String username);
}

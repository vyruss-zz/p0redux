package bank.p0redux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.p0redux.models.User;
import bank.p0redux.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userR;
	public List<User> getAllUsers() {
		return userR.findAll();
	}
	
	public User getUserById(int id) {
		return userR.findByUserId(id);
	}
	
	
	public UserService(UserRepo userR) {
		this.userR=userR;
	}
	
	public User createUser(User user) {
		return userR.save(user);
	}
	
	public User findUserByUsername(String username) {
		return userR.findByUsername(username);
	}
	
	public void updateUser(User user) {
		this.userR.save(user);
	}
}

package bank.p0redux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.p0redux.models.Account;
import bank.p0redux.repository.AccountRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo accountR;
	
	public AccountService(AccountRepo accountR) {
		this.accountR=accountR;
	}
	
	public List<Account> getAllAccounts() {
		return accountR.findAll();
	}
	
	public Account getAccountById(int id) {
		return accountR.findByAccountId(id);
	}
}

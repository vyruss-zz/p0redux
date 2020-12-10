package bank.p0redux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.p0redux.models.Account;
import bank.p0redux.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {


	@Autowired
	private AccountService accountS;
	

	public AccountController(AccountService accountS) {

		this.accountS=accountS;

	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountS.getAllAccounts();
	}
	

}

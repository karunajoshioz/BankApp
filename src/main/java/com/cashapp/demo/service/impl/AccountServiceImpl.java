package com.cashapp.demo.service.impl;

import com.cashapp.demo.model.Account;
import com.cashapp.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void deposit(double amount, String user) {
		Account account = new Account();
		account.setAccountName(user);
		account.setBalance(amount);
		accountRepository.save(account);
	}

	@Override
	public String withdraw(double amount, String user) {
		Account account = accountRepository.findByAccountName(user);
		if (account.getBalance() > amount) {
			account.setBalance(account.getBalance() - (amount));
			accountRepository.save(account);
			return "Withdrawal successful";
		} else {
			return "Withdrawal Amount is exceed the current Balance";
		}

	}

	@Override
	public Double balance(String user) {
		return accountRepository.findByAccountName(user).getBalance();
	}

}

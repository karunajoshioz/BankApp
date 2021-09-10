package com.cashapp.demo;

import com.cashapp.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTest {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountService accountService;

	private String firstUsername = "JaneDoe";
	private double depAmt = 30.0;
	private double withdrawalAmt1 =20.0;
	private double withdrawalAmt2 =11.0;

	@After
	public void after() {
		accountRepository.deleteAll();
	}
	
	@Test
	public void isDepositPerformed() {
		accountService.deposit(depAmt, firstUsername);
		double checkAmt = accountService.balance(firstUsername);
		assertEquals(depAmt, checkAmt);
	}
	
	@Test
	public void isWithdrawPerformed() {
		accountService.deposit(depAmt, firstUsername);
		String msg = accountService.withdraw(withdrawalAmt1, firstUsername);
		Assertions.assertThat(msg).isEqualTo("Withdrawal successful");
	}
	
	@Test
	public void isWithdrwalNegative() {
		accountService.deposit(depAmt, firstUsername);
		accountService.withdraw(withdrawalAmt1, firstUsername);
		String msg = accountService.withdraw(withdrawalAmt2, firstUsername);
		Assertions.assertThat(msg).isEqualTo("Withdrawal Amount is exceed the current Balance");
	}
	

}

package com.cashapp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping(value = "/deposit")
	public ResponseEntity<String> deposit(@RequestParam(required = true) String amount,
			@RequestParam(required = true) String name) {
		accountService.deposit(Double.parseDouble(amount), name);
		return new ResponseEntity<String>("Successful Deposit", HttpStatus.OK);
	}

	@PostMapping(value = "/withdraw")
	public ResponseEntity<String> withdraw(@RequestParam(required = true) String amount,
			@RequestParam(required = true) String name) {
		String msg = accountService.withdraw(Double.parseDouble(amount), name);
		if (msg.contains("Sucess"))
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		else
			return new ResponseEntity<String>(msg, HttpStatus.FORBIDDEN);
	}

	@GetMapping(value = "/balance")
	public ResponseEntity<String> balance(@RequestParam(required = true) String name) {
		String bal = String.valueOf(accountService.balance(name));
		return new ResponseEntity<String>("Balance is::" + bal, HttpStatus.OK);
	}
}

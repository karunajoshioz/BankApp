package com.example.demo.service;

public interface AccountService {
    void deposit(double amount, String user);

    String withdraw(double amount, String user);
    Double balance( String user);
}

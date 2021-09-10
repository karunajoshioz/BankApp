package com.cashapp.demo.repository;

import com.cashapp.demo.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByAccountName(String accountName);
}

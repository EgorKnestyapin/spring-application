package com.example.springapplication.service;

import com.example.springapplication.entity.Account;
import com.example.springapplication.entity.Bill;
import com.example.springapplication.exception.AccountNotFoundException;
import com.example.springapplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long save(String name, String email, List<Bill> bills) {
        Account account = new Account(name, email, bills);
        return accountRepository.save(account).getAccountId();
    }

    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Can't find account with id: " + accountId));
    }

    public Account update(Account account) {
        return accountRepository.save(account);
    }
}

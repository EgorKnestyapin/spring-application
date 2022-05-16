package com.example.springapplication.service;

import com.example.springapplication.entity.Account;
import com.example.springapplication.entity.Bill;
import com.example.springapplication.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    private final AccountService accountService;

    @Autowired
    public PaymentService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Object pay(Long accountId, BigDecimal paymentAmount) {
        Account account = accountService.getAccountById(accountId);
        Bill defaultBill = AccountUtils.findDefaultBill(account);
        defaultBill.setAmount(defaultBill.getAmount().subtract(paymentAmount));
        accountService.update(account);
        return "Success";
    }
}

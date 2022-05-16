package com.example.springapplication.utils;

import com.example.springapplication.entity.Account;
import com.example.springapplication.entity.Bill;
import com.example.springapplication.exception.NotDefaultBillException;

public class AccountUtils {

    public static Bill findDefaultBill(Account accountFrom) {
        return accountFrom.getBills().stream().filter(Bill::getDefault)
                .findAny()
                .orElseThrow(() -> new NotDefaultBillException("Unable to find default bill for account with id: "
                        + accountFrom.getAccountId()));
    }
}

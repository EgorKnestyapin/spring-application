package com.example.springapplication.controller;

import com.example.springapplication.controller.dto.AccountRequestDTO;
import com.example.springapplication.controller.dto.AccountResponseDTO;
import com.example.springapplication.entity.Bill;
import com.example.springapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{accountId}")
    public AccountResponseDTO getById(@PathVariable Long accountId) {
        return new AccountResponseDTO(accountService.getAccountById(accountId));
    }

    @PostMapping("/accounts")
    public Long create(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.save(accountRequestDTO.getName(), accountRequestDTO.getEmail(), accountRequestDTO.getBills()
                .stream()
                .map(billRequestDTO -> new Bill(billRequestDTO.getAmount(), billRequestDTO.getDefault()))
                .collect(Collectors.toList()));
    }
}

package com.example.springapplication.controller;

import com.example.springapplication.controller.dto.TransferRequestDTO;
import com.example.springapplication.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfers")
    public Object transfer(@RequestBody TransferRequestDTO transferRequestDTO) {
        return transferService.transfer(transferRequestDTO.getAccountIdFrom(), transferRequestDTO.getAccountIdTo(), transferRequestDTO.getAmount());
    }
}

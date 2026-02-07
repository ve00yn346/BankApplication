package com.bankapp.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.bankapp.dto.*;
import com.bankapp.service.TransactionService;

@RestController
@RequestMapping("/bankapp/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PutMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferRequestDto dto) {
        transactionService.transfer(dto.getFromAccountId(), dto.getToAccountId(), dto.getAmount());
        return ResponseEntity.ok("Transfer successful");
    }

    @PutMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody DepositRequestDto dto) {
        transactionService.deposit(dto.getAccountId(), dto.getAmount());
        return ResponseEntity.ok("Deposit successful");
    }

    @PutMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody WithdrawRequestDto dto) {
        transactionService.withdraw(dto.getAccountId(), dto.getAmount());
        return ResponseEntity.ok("Withdraw successful");
    }
}

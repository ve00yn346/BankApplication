package com.bankapp.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import com.bankapp.dto.AccountCreateRequestDto;
import com.bankapp.dto.AccountResponseDto;
import com.bankapp.dto.AccountUpdateRequestDto;
import com.bankapp.dto.BalanceResponseDto;
import com.bankapp.entity.Account;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping("/bankapp/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponseDto> create(@RequestBody AccountCreateRequestDto dto) {
        Account account = new Account(null, dto.getName(), dto.getInitialBalance());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toResponse(accountService.createAccount(account)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(toResponse(accountService.getAccountById(id)));
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<BalanceResponseDto> getBalance(@PathVariable Integer id) {
        BigDecimal balance = accountService.getBalance(id);
        return ResponseEntity.ok(new BalanceResponseDto(id, balance));
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDto>> getAll() {
        return ResponseEntity.ok(accountService.getAllAccounts().stream()
                .map(this::toResponse)
                .toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponseDto> update(@PathVariable Integer id, @RequestBody AccountUpdateRequestDto dto) {
        Account account = new Account(id, dto.getName(), dto.getBalance());
        return ResponseEntity.ok(toResponse(accountService.updateAccount(id, account)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    private AccountResponseDto toResponse(Account account) {
        return new AccountResponseDto(account.getId(), account.getName(), account.getBalance());
    }
}

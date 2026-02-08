package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bankapp.entity.Account;
import com.bankapp.exception.AccountNotFoundException;
import com.bankapp.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Integer id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id " + id));
    }

    @Override
    public Account updateAccount(Integer id, Account account) {
        Account existing = getAccountById(id);
        if (account.getName() != null) {
            existing.setName(account.getName());
        }
        if (account.getBalance() != null) {
            existing.setBalance(account.getBalance());
        }
        return accountRepository.save(existing);
    }

    @Override
    public BigDecimal getBalance(Integer id) {
        Account account = getAccountById(id);
        BigDecimal balance = account.getBalance();
        return balance != null ? balance : BigDecimal.ZERO;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(Integer id) {
        accountRepository.deleteById(id);
    }
}

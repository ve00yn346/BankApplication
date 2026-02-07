package com.bankapp.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.entity.Account;
import com.bankapp.exception.AccountNotFoundException;
import com.bankapp.repository.AccountRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;

    public TransactionServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private Account getAccount(Integer id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id " + id));
    }

    @Override
    public void transfer(Integer fromAcc, Integer toAcc, BigDecimal amount) {
        Account from = getAccount(fromAcc);
        Account to = getAccount(toAcc);

        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        accountRepository.save(from);
        accountRepository.save(to);
    }

    @Override
    public void deposit(Integer accId, BigDecimal amount) {
        Account acc = getAccount(accId);
        BigDecimal accBalance=acc.getBalance();
        if(accBalance==null) accBalance=BigDecimal.ZERO;
        acc.setBalance(accBalance.add(amount));
        accountRepository.save(acc);
    }

    @Override
    public void withdraw(Integer accId, BigDecimal amount) {
        Account acc = getAccount(accId);
        acc.setBalance(acc.getBalance().subtract(amount));
        accountRepository.save(acc);
    }
}

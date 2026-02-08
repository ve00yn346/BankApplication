package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import com.bankapp.entity.Account;

public interface AccountService {

    Account createAccount(Account account);
    Account getAccountById(Integer id);
    Account updateAccount(Integer id, Account account);
    BigDecimal getBalance(Integer id);
    List<Account> getAllAccounts();
    void deleteAccount(Integer id);
}

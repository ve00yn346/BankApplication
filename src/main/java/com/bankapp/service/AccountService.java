package com.bankapp.service;

import java.util.List;
import com.bankapp.entity.Account;

public interface AccountService {

    Account createAccount(Account account);
    Account getAccountById(Integer id);
    List<Account> getAllAccounts();
    void deleteAccount(Integer id);
}

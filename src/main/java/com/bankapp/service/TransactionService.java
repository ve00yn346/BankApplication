package com.bankapp.service;

import java.math.BigDecimal;

public interface TransactionService {

    void transfer(Integer fromAcc, Integer toAcc, BigDecimal amount);
    void deposit(Integer accId, BigDecimal amount);
    void withdraw(Integer accId, BigDecimal amount);
}

package com.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}

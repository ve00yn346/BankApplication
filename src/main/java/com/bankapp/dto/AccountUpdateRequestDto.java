package com.bankapp.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AccountUpdateRequestDto {

    private String name;
    private BigDecimal balance;
}

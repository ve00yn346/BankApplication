package com.bankapp.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AccountCreateRequestDto {

    private String name;
    private BigDecimal initialBalance;
}

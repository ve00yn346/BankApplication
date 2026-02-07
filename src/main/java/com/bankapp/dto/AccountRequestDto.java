package com.bankapp.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AccountRequestDto {

    private String name;
    private BigDecimal balance;
}

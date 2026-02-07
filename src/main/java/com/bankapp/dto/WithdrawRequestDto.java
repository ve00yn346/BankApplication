package com.bankapp.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class WithdrawRequestDto {

    private int accountId;
    private BigDecimal amount;
}

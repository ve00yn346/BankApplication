package com.bankapp.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TransferRequestDto {

    private int fromAccountId;
    private int toAccountId;
    private BigDecimal amount;
}

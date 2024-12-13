package com.shop.pay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class AccountResponseDTO {
    @JsonProperty("accountBalance")
    BigDecimal accountBalance;

    public AccountResponseDTO(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}

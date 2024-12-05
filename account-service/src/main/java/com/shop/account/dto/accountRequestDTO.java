package com.shop.account.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class accountRequestDTO {


    private String accountName;

    private String email;

    private BigDecimal balance;
}

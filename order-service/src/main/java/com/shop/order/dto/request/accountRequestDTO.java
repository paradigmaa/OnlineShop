package com.shop.order.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class accountRequestDTO {

    @JsonProperty("accountName")
    private String accountName;

    @JsonProperty("accountEmail")
    private String email;

    @JsonProperty("accountBalance")
    private BigDecimal balance;
}

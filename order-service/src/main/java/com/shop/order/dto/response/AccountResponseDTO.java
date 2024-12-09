package com.shop.order.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDTO {

    private Long id;

    @JsonProperty("accountName")
    private String accountName;

    @JsonProperty("accountEmail")
    private String accountEmail;

    @JsonProperty("accountBalance")
    private BigDecimal balance;

}

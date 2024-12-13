package com.shop.order.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDTO {
    @JsonProperty("accountId")
    private Long id;
    @JsonProperty("accountName")
    private String accountName;
    @JsonProperty("accountEmail")
    private String email;
    @JsonProperty("accountBalance")
    private BigDecimal balance;
    @JsonProperty("createdAt")
    private Date createdAt;
    @JsonProperty("lastUpdate")
    private Date lastUpdate;


}

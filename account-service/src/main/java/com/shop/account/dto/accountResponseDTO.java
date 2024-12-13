package com.shop.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.account.entity.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class accountResponseDTO {
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

    public accountResponseDTO(Account account) {
        this.id = account.getId();
        this.accountName = account.getAccountName();
        this.email = account.getEmail();
        this.balance = account.getBalance();
        this.createdAt = account.getCreatedAt();
        this.lastUpdate = account.getLastUpdate();
    }
}

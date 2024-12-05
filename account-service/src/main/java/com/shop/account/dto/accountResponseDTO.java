package com.shop.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
    private Long id;
    @JsonProperty("accountName")
    private String accountName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("balance")
    private BigDecimal balance;
    @JsonProperty("createdAt")
    private Date createdAt;
    @JsonProperty("lastUpdate")
    private Date lastUpdate;
}

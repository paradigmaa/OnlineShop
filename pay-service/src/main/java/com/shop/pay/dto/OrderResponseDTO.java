package com.shop.pay.dto;

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
public class OrderResponseDTO {
    @JsonProperty("orderId")
    private Long Id;

    @JsonProperty("accountId")
    private Long accountId;

    @JsonProperty("itemId")
    private Long itemId;

    @JsonProperty("accountName")
    private String accountName;

    @JsonProperty("accountEmail")
    private String email;

    @JsonProperty("itemName")
    private String itemName;

    @JsonProperty("accountBalance")
    private BigDecimal accountBalance;

    @JsonProperty("itemPrice")
    private BigDecimal price;

    @JsonProperty("itemQuantity")
    private Long quantityItems;

    @JsonProperty("totalAmountOrder")
    private BigDecimal totalAmountOrder;

    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonProperty("lastUpdate")
    private Date lastUpdate;
}

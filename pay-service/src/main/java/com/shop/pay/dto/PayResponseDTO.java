package com.shop.pay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class PayResponseDTO {
    @JsonProperty("payId")
    private Long payId;

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

    @JsonProperty("totalAmountOrder")
    private BigDecimal totalAmountOrder;

    @JsonProperty("itemPrice")
    private BigDecimal price;

    @JsonProperty("itemQuantity")
    private Long quantityItems;

    @JsonProperty("createdAt")
    private Date createdAt;
}

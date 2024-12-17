package com.shop.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResponseDTO {
    @JsonProperty("orderId")
    private Long Id;

    @JsonProperty("accountId")
    private Long accountId;
}

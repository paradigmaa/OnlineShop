package com.shop.pay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayRequestDTO {
    @JsonProperty("orderId")
    private Long orderId;
}

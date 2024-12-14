package com.shop.order.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    @JsonProperty("accountId")
    private Long accountId;

    @JsonProperty("itemId")
    private Long itemId;

    @JsonProperty("itemQuantity")
    private Long quantityItem;
}

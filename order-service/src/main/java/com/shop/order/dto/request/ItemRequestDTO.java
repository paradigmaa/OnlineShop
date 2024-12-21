package com.shop.order.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDTO {
    @JsonProperty("itemName")
    private String itemName;

    @JsonProperty("itemQuantity")
    private Long quantity;

    @JsonProperty("itemPrice")
    private BigDecimal price;
}

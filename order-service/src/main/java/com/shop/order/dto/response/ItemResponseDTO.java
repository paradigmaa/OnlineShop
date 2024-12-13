package com.shop.order.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDTO {
    @JsonProperty("itemId")
    private Long id;

    @JsonProperty("itemName")
    private String itemName;

    @JsonProperty("itemQuantity")
    private Long quantity;

    @JsonProperty("itemPrice")
    private BigDecimal price;

}
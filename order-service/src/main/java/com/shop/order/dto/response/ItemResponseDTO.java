package com.shop.order.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDTO {

    private Long id;

    @JsonProperty("itemName")
    private String itemName;


    @JsonProperty("priceItem")
    private Long price;

    @JsonProperty("quantity")
    private Long quantityItems;
}

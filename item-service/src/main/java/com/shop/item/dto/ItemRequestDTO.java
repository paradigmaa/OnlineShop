package com.shop.item.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
public class ItemRequestDTO {
    private Long id;

    @JsonProperty("itemName")
    private String itemName;

    @JsonProperty("itemQuantity")
    private Long quantity;

    @JsonProperty("itemPrice")
    private BigDecimal price;

    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonProperty("lastUpdate")
    private Date lastUpdate;
}

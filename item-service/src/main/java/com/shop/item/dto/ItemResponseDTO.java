package com.shop.item.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.item.entity.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDTO {
    @JsonProperty("itemId")
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


    public ItemResponseDTO(Item item) {
        this.id = item.getId();
        this.itemName = item.getItemName();
        this.quantity = item.getQuantity();
        this.price = item.getPrice();
        this.createdAt = item.getCreatedAt();
        this.lastUpdate = item.getLastUpdate();
    }
}

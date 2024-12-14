package com.shop.order.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.order.entity.Order;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderResponseDTO {

    @JsonProperty("orderId")
    private Long Id;

    @JsonProperty("accountId")
    private Long accountId;

    @JsonProperty("itemId")
    private Long itemId;

    @JsonProperty("accountName")
    private String accountName;

    @JsonProperty("itemName")
    private String itemName;

    @JsonProperty("accountEmail")
    private String email;

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

    public OrderResponseDTO(Order order) {
        Id = order.getId();
        this.accountId = order.getAccountId();
        this.itemId = order.getItemId();
        this.accountName = order.getAccountName();
        this.itemName = order.getItemName();
        this.accountBalance = order.getAccountBalance();
        this.quantityItems = order.getQuantityItems();
        this.email = order.getEmail();
    }
}

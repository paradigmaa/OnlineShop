package com.shop.order.dto.response;

import com.shop.order.entity.Order;
import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderResponseDTO {

    private Long Id;

    private Long accountId;

    private Long itemId;

    private String accountName;

    private String email;

    private String itemName;

    private BigDecimal accountBalance;

    private Long quantityItems;

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

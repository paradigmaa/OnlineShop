package com.shop.order.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.order.dto.response.OrderResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Order_DB")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "email")
    private String email;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price_item")
    private BigDecimal price;

    @Column(name = "quantity_item")
    private Long quantityItems;

    @Column(name = "account_balance")
    private BigDecimal accountBalance;

    @Column(name = "total_amount_order")
    private BigDecimal totalAmountOrder;

    @Column(name = "date_created", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}

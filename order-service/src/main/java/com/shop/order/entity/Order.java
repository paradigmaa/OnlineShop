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
@Table(name = "OrderDB")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "account_id")
    @JsonProperty("accountId")
    private Long accountId;

    @Column(name = "item_id")
    @JsonProperty("itemId")
    private Long itemId;

    @Column(name = "account_name")
    @JsonProperty("accountName")
    private String accountName;

    @Column(name = "email")
    @JsonProperty("accountEmail")
    private String email;

    @Column(name = "item_name")
    @JsonProperty("itemName")
    private String itemName;

    @Column(name = "account_balance")
    @JsonProperty("accountBalance")
    private BigDecimal accountBalance;

    @Column(name = "price_items")
    @JsonProperty("priceItem")
    private Long price;

    @Column(name = "quantity_items")
    @JsonProperty("quantityItems")
    private Long quantityItems;

    @Column(name = "date_created", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("createdAt")
    private Date createdAt;

    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("lastUpdate")
    private Date lastUpdate;

}

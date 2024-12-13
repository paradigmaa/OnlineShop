package com.shop.pay.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "Pay")
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "account_balance")
    private BigDecimal accountBalance;

    @Column(name = "status")
    private String status;

    @Column(name = "email")
    private String email;

    @Column(name = "total_amount_order")
    private BigDecimal totalAmountOrder;
}

package com.shop.item.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long itemId;

    private String itemName;

    private String itemDescription;

    private Long itemPrice;

    private Long itemQuantity;

    private String itemCategory;

    private String Supplier;


}

package com.shop.pay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
    private Long Id;

    private Long accountId;

    private Long itemId;

    private String accountName;

    private String itemName;

    private Date createdAt;

    private Date lastUpdate;
}

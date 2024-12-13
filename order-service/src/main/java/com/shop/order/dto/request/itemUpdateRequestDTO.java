package com.shop.order.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class itemUpdateRequestDTO {
    @JsonProperty("itemQuantity")
    private Long newBalance;

    public itemUpdateRequestDTO(Long newBalance) {
        this.newBalance = newBalance;
    }
}

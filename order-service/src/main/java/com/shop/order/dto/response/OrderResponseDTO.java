package com.shop.order.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderResponseDTO {
    private Long Id;

    private Long accountId;

    private Long itemId;
}

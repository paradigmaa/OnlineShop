package com.shop.order.mapper;

import com.shop.order.dto.request.OrderRequestDTO;
import com.shop.order.dto.response.OrderResponseDTO;
import com.shop.order.entity.Order;

public class OrderMapper {
    public static OrderResponseDTO mapOrderToOrderResponseDTO (Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setId(order.getId());
        dto.setAccountId(order.getAccountId());
        dto.setItemId(order.getItemId());
        dto.setItemName(order.getItemName());
        dto.setAccountName(order.getAccountName());
        return dto;
    }
    public static Order mapOrderRequstDTOToOrder (OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        order.setAccountId(orderRequestDTO.getAccountId());
        order.setItemId(order.getItemId());
        return order;
    }
    public static Order mapOrderResponseDTOToOrder (OrderResponseDTO orderResponseDTO) {
        Order order = new Order();
        order.setAccountId(orderResponseDTO.getAccountId());
        order.setItemId(order.getItemId());
        return order;
    }

}

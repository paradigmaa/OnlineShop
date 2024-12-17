package com.shop.orderservice.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.order.dto.request.OrderRequestDTO;
import com.shop.order.dto.response.AccountResponseDTO;
import com.shop.order.dto.response.ItemResponseDTO;
import com.shop.order.dto.response.OrderResponseDTO;
import com.shop.order.repository.OrderRepository;
import com.shop.order.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OrderIntegrationTest {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Test
    public void testOrderIntegration() {
        OrderRequestDTO orderRequestDTO = createOrderRequest();
        AccountResponseDTO accountResponseDTO = createAccount();
        ItemResponseDTO itemResponseDTO = createItem();
         String result = orderService.createOrder(orderRequestDTO);
         Assert.assertEquals("Уважаемый Test, ваш заказ  Test успешно оформлен в количестве 5 " +
                 "общая сумма заказа: 500",result);
    }


    private AccountResponseDTO createAccount() {
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
        accountResponseDTO.setId(1L);
        accountResponseDTO.setAccountName("Test");
        accountResponseDTO.setEmail("Test@test.com");
        accountResponseDTO.setBalance(new BigDecimal("100.00"));
        return accountResponseDTO;
    }

    private ItemResponseDTO createItem() {
        ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
        itemResponseDTO.setId(1L);
        itemResponseDTO.setItemName("Test");
        itemResponseDTO.setPrice(new BigDecimal("100.00"));
        itemResponseDTO.setQuantity(5L);
        return itemResponseDTO;
    }

    private OrderRequestDTO createOrderRequest() {
        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setAccountId(1L);
        orderRequestDTO.setItemId(1L);
        orderRequestDTO.setQuantityItem(5L);
        return orderRequestDTO;
    }


}
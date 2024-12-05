package com.shop.order.controller;

import com.shop.order.dto.request.OrderRequestDTO;
import com.shop.order.dto.response.AccountResponseDTO;
import com.shop.order.dto.response.ItemResponseDTO;
import com.shop.order.dto.response.OrderResponseDTO;
import com.shop.order.mapper.OrderMapper;
import com.shop.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponseDTO> createOrder (@RequestBody OrderRequestDTO requestDTO) {
        return new ResponseEntity<OrderResponseDTO>(orderService.createOrder(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get/{orderId}")
    public ResponseEntity<OrderResponseDTO> getOrder(@PathVariable Long orderId){
       return new ResponseEntity<OrderResponseDTO>(OrderMapper.mapOrderToOrderResponseDTO(orderService.getOrderById(orderId)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Delete order" + orderId );
    }

    @PostMapping("/update/{orderId}")
    public ResponseEntity<OrderResponseDTO> updateOrder(@PathVariable Long orderId, @RequestBody OrderRequestDTO orderRequestDTO){
        return new ResponseEntity<OrderResponseDTO>(orderService.updateOrder(orderId, orderRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/account/{accountId}/items")
    public List<ItemResponseDTO> accountItems(@PathVariable Long accountId){
        return orderService.getItemsAccount(accountId);
    }

    @GetMapping("/item/{itemId}/accounts")
    public List<AccountResponseDTO> itemAccount(@PathVariable Long itemId) {
        return orderService.getAccountsItem(itemId);
    }

    @GetMapping("/get")
    public List<OrderResponseDTO> getOrders(){
        return orderService.getAllOrders();
    }


}

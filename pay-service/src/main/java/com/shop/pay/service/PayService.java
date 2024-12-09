package com.shop.pay.service;

import com.shop.pay.dto.OrderDTO;
import com.shop.pay.dto.OrderResponseDTO;
import com.shop.pay.entity.Pay;
import com.shop.pay.repository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PayService {

    @Autowired
    private final PayRepository payRepository;
    @Autowired
    private final RestTemplate restTemplate;

    public PayService(PayRepository payRepository, RestTemplate restTemplate) {
        this.payRepository = payRepository;
        this.restTemplate = restTemplate;
    }
    String orderUlr = "http://192.168.0.106:8083/orders/get/";

    public Pay createPayment(Long OrderId){
        ResponseEntity<OrderResponseDTO>getOrder = restTemplate.getForEntity(orderUlr + OrderId, OrderResponseDTO.class);
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setId(getOrder.getBody().getId());
        return null;
    }
}

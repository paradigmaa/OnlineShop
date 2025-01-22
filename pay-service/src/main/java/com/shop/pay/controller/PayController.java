package com.shop.pay.controller;

import com.shop.pay.entity.Pay;
import com.shop.pay.service.PayService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PayController {
    private final PayService payService;

    @Autowired
    public PayController(PayService payService) {
        this.payService = payService;
    }

    @PostMapping("/create")
    public String createPay(@RequestBody Pay pay) {
        return payService.createPayment(pay);
    }

    @GetMapping("/get")
    public List<Pay> getPayList() {
        return payService.getPay();
    }
}

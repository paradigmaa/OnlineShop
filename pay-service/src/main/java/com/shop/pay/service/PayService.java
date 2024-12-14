package com.shop.pay.service;

import com.shop.pay.dto.AccountResponseDTO;
import com.shop.pay.dto.OrderResponseDTO;
import com.shop.pay.entity.Pay;
import com.shop.pay.repository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;

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
    String accountUrl = "http://192.168.0.106:8081/accounts/update/";

    public String createPayment(Pay pay) {
        ResponseEntity<OrderResponseDTO> getOrder = restTemplate.getForEntity(orderUlr + pay.getOrderId(), OrderResponseDTO.class);
        OrderResponseDTO orderResponseDTO = getOrder.getBody();
        if (orderResponseDTO.getAccountBalance().compareTo(orderResponseDTO.getTotalAmountOrder()) >= 0) {
            Pay create = paymentSuccessful(orderResponseDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            AccountResponseDTO accountResponseDTO = new AccountResponseDTO(create.getAccountBalance().subtract(create.getTotalAmountOrder()));
            HttpEntity<AccountResponseDTO> requestEntity = new HttpEntity<>(accountResponseDTO, headers);
            ResponseEntity<AccountResponseDTO> response = restTemplate.exchange(
                    accountUrl + create.getAccountId(),
                    HttpMethod.POST,
                    requestEntity,
                    AccountResponseDTO.class
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                return String.format("Заказ оплачен: Пользователь %s, баланс %s, почта %s, товар %s",
                        create.getAccountName(), create.getAccountBalance(), create.getEmail(),
                        create.getItemName());
            } else {
                return String.format("Заказ не удалось оплатить по техническим причинам: Пользователь %s, баланс %s, почта %s, товар %s",
                        create.getAccountName(), create.getAccountBalance(), create.getEmail(),
                        create.getItemName());
            }
        }
        Pay create = paymentFailed(orderResponseDTO);
        return String.format("Заказ не удалось оплатить: у пользователя %s не хватает средств для оплаты," +
                        "сумма оплаты %s, баланс %s",
                create.getAccountName(), create.getTotalAmountOrder(), create.getAccountBalance());

    }

    private Pay paymentSuccessful(OrderResponseDTO orderResponseDTO) {
        Pay create = new Pay();
        create.setOrderId(orderResponseDTO.getId());
        create.setAccountId(orderResponseDTO.getAccountId());
        create.setEmail(orderResponseDTO.getEmail());
        create.setItemId(orderResponseDTO.getItemId());
        create.setAccountName(orderResponseDTO.getAccountName());
        create.setItemName(orderResponseDTO.getItemName());
        create.setTotalAmountOrder(orderResponseDTO.getTotalAmountOrder());
        create.setAccountBalance(orderResponseDTO.getAccountBalance());
        create.setOrderId(orderResponseDTO.getId());
        create.setCreatedAt(new Date());
        create.setStatus("Оплата прошла успешно");
        return payRepository.save(create);
    }

    private Pay paymentFailed(OrderResponseDTO orderResponseDTO) {
        Pay create = new Pay();
        create.setOrderId(orderResponseDTO.getId());
        create.setAccountId(orderResponseDTO.getAccountId());
        create.setEmail(orderResponseDTO.getEmail());
        create.setItemId(orderResponseDTO.getItemId());
        create.setAccountName(orderResponseDTO.getAccountName());
        create.setItemName(orderResponseDTO.getItemName());
        create.setAccountBalance(orderResponseDTO.getAccountBalance());
        create.setCreatedAt(new Date());
        create.setStatus("Оплата не прошла");
        return payRepository.save(create);
    }
}

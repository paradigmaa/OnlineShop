package com.shop.order.service;

import com.shop.order.dto.request.itemUpdateRequestDTO;
import com.shop.order.exception.NotFoundAccountOrItem;
import com.shop.order.repository.OrderRepository;
import com.shop.order.dto.request.OrderRequestDTO;
import com.shop.order.dto.response.AccountResponseDTO;
import com.shop.order.dto.response.ItemResponseDTO;
import com.shop.order.dto.response.OrderResponseDTO;
import com.shop.order.entity.Order;
import com.shop.order.exception.NotFoundOrderException;
import com.shop.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    private final RestTemplate restTemplate;

    private final OrderRepository orderRepository;

    final String urlAccount = "http://192.168.0.106:8081/accounts/get/";
    final String urlItem = "http://192.168.0.106:8082/items/get/";
    final String updateItemUrl = "http://192.168.0.106:8082/items/update/";

    @Autowired
    public OrderService(RestTemplate restTemplate, OrderRepository orderRepository) {
        this.restTemplate = restTemplate;
        this.orderRepository = orderRepository;
    }

    public String createOrder(OrderRequestDTO requestDTO) {
        ResponseEntity<AccountResponseDTO> accountResponsRest = restTemplate.getForEntity(urlAccount + requestDTO.getAccountId(), AccountResponseDTO.class);
        ResponseEntity<ItemResponseDTO> itemsResponsRest = restTemplate.getForEntity(urlItem + requestDTO.getItemId(), ItemResponseDTO.class);
        AccountResponseDTO accountResponseDTO = accountResponsRest.getBody();
        ItemResponseDTO itemResponseDTO = itemsResponsRest.getBody();

        if (accountResponseDTO.getId() == null && itemResponseDTO.getId() == null &&
                itemResponseDTO.getQuantity() == null) {
            throw new NotFoundAccountOrItem("Not account or item");
        }

        if (itemResponseDTO.getQuantity() - requestDTO.getQuantityItem() > 0) {
            Order order = new Order();
            order.setAccountId(accountResponseDTO.getId());
            order.setItemId(itemResponseDTO.getId());
            order.setAccountName(accountResponseDTO.getAccountName());
            order.setItemName(itemResponseDTO.getItemName());
            order.setAccountBalance(accountResponseDTO.getBalance());
            order.setQuantityItems(requestDTO.getQuantityItem());
            order.setEmail(accountResponseDTO.getEmail());
            order.setPrice(itemResponseDTO.getPrice());
            BigDecimal totalOrderAmount = order.getPrice().multiply(new BigDecimal(order.getQuantityItems()));
            order.setTotalAmountOrder(totalOrderAmount);
            order.setCreatedAt(new Date());
            orderRepository.save(order);
            Long remainingGoods = itemResponseDTO.getQuantity() - requestDTO.getQuantityItem();
            String urlUpdateItem = updateItemUrl + requestDTO.getItemId();
            itemUpdateRequestDTO newBalance = new itemUpdateRequestDTO(remainingGoods);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<itemUpdateRequestDTO> httpEntity = new HttpEntity<>(newBalance, headers);
            ResponseEntity<itemUpdateRequestDTO>response =  restTemplate.exchange(
                    urlUpdateItem,
                    HttpMethod.POST,
                    httpEntity,
                    itemUpdateRequestDTO.class
            );
            return String.format("Уважаемый %S, ваш заказ  %s успешно оформлен в количестве %s" +
                            " общая сумма заказа: %s ", order.getAccountName(), order.getItemName(),
                    order.getQuantityItems(),totalOrderAmount);
        }else{
            return String.format("Количество товара %s  %d, ваш заказ %s превышает лимит", itemResponseDTO.getItemName()
            ,itemResponseDTO.getQuantity(),requestDTO.getQuantityItem());
        }
    }

    @Transactional(readOnly = true)
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new NotFoundOrderException("Not found Order by" + orderId));

    }

    @Transactional(readOnly = true)
    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(OrderMapper::mapOrderToOrderResponseDTO).collect(Collectors.toList());
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public List<Order> findOrderByAccountId(Long accountId) {
        return orderRepository.findOrderByAccountId(accountId);
    }

    public OrderResponseDTO updateOrder(Long orderId, OrderRequestDTO orderRequestDTO) {
        Order orderToUpdate = getOrderById(orderId);
        orderToUpdate.setAccountId(orderRequestDTO.getAccountId());
        orderToUpdate.setItemId(orderRequestDTO.getItemId());
        Order save = orderRepository.save(orderToUpdate);
        return OrderMapper.mapOrderToOrderResponseDTO(save);
    }

    @Transactional(readOnly = true)
    public List<ItemResponseDTO> getItemsAccount(Long accountId) {
        ResponseEntity<AccountResponseDTO> accountRestDTO = restTemplate.getForEntity(urlAccount + accountId, AccountResponseDTO.class);
        List<Order> orders = orderRepository.findByAccountId(accountRestDTO.getBody().getId());
        List<ItemResponseDTO> result = new ArrayList<>();
        for (Order order : orders) {
            ResponseEntity<ItemResponseDTO> itemRestDTO = restTemplate.getForEntity(urlItem + order.getItemId(), ItemResponseDTO.class);
            result.add(itemRestDTO.getBody());
        }
        return result.isEmpty() ? null : result;
    }

    @Transactional(readOnly = true)
    public List<AccountResponseDTO> getAccountsItem(Long itemId) {
        ResponseEntity<ItemResponseDTO> itemRestDTO = restTemplate.getForEntity(urlItem + itemId, ItemResponseDTO.class);
        List<Order> orders = orderRepository.findByItemId(itemRestDTO.getBody().getId());
        List<AccountResponseDTO> result = new ArrayList<>();
        for (Order order : orders) {
            ResponseEntity<AccountResponseDTO> accountRestDTO = restTemplate.getForEntity(urlAccount + order.getAccountId(), AccountResponseDTO.class);
            result.add(accountRestDTO.getBody());
        }
        return result.isEmpty() ? null : result;
    }
}


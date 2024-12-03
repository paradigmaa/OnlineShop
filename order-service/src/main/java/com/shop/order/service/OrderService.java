package com.shop.order.service;
import com.shop.account.entity.Account;
import com.shop.order.OrderRepository.OrderRepository;
import com.shop.order.dto.ResponseItemDTO;
import com.shop.order.entity.Order;
import com.shop.item.entity.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final RestTemplate restTemplate;

    private final OrderRepository orderRepository;

    String urlAccount = "http://192.168.158.123:8081/accounts/";
    String urlItem = "http://192.168.158.123:8082/items/";

    public OrderService(RestTemplate restTemplate, OrderRepository orderRepository) {
        this.restTemplate = restTemplate;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        Account account = restTemplate.getForObject(urlAccount + accountId, Account.class);
        Item item = restTemplate.getForObject(urlItem + itemId, Item.class);
        Order order = new Order();
        order.setAccountId(account.getId());
        order.setItemId(item.getItemId());
        return orderRepository.save(order);
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findOrderById(orderId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public Order updateOrder(Long accountId, Long itemId, Order order) {
        Order orderToUpdate = new Order();
        order.setAccountId(accountId);
        order.setItemId(itemId);
        return orderRepository.save(orderToUpdate);
    }

    public List<ResponseItemDTO> getItemsAccount(Long accountId) {
        Account account = restTemplate.getForObject(urlAccount + accountId, Account.class);
        List<Order>orders = orderRepository.findByAccountId(account.getId());
        List<Item>result = new ArrayList<>();
        for (Order order : orders) {
            Item item = restTemplate.getForObject(urlItem + order.getItemId(), Item.class);
            result.add(item);
        }
        return result.isEmpty() ? null : result;
    }

    public List<Account> getAccountItems(Long itemId) {
        Item item = restTemplate.getForObject(urlItem + itemId, Item.class);
        List<Order> orders = orderRepository.findByItemId(item.getItemId());
        List<Account> result = new ArrayList<>();
        for (Order order : orders) {
            Account account = restTemplate.getForObject(urlAccount + order.getAccountId(), Account.class);
            result.add(account);
        }
        return result.isEmpty() ? null : result;
    }




}


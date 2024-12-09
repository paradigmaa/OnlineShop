package com.shop.order.repository;
import com.shop.order.dto.response.AccountResponseDTO;
import com.shop.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findByAccountId(Long id);
    public List<Order> findByItemId(Long id);
    public Order findOrderById(Long id);
    public List<Order>findOrderByAccountId(Long accountId);
    public List<Order>findOrderByItemId(Long itemId);
}

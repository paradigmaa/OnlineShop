package com.shop.order.OrderRepository;
import com.shop.order.entity.Order;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findByAccountId(Long id);
    public List<Order> findByItemId(Long id);
    public Order findOrderById(Long id);
}

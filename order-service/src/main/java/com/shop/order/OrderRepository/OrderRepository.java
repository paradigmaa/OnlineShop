package com.shop.order.OrderRepository;
import com.shop.order.dto.response.OrderResponseDTO;
import com.shop.order.entity.Order;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findByAccountId(Long id);
    public List<Order> findByItemId(Long id);
    public Order findOrderById(Long id);
}

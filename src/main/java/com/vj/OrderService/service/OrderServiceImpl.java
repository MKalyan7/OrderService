package com.vj.OrderService.service;

import com.vj.OrderService.entity.Order;
import com.vj.OrderService.model.OrderRequest;
import com.vj.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public long placeOrder(OrderRequest orderRequest) {

        log.info("Placing Order Request: {}", orderRequest);

        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .quantity(orderRequest.getQuantity())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .build();
        order = orderRepository.save(order);

        log.info("Order Placed successfully with Order ID : {}",order.getId());

        return order.getId();
    }
}

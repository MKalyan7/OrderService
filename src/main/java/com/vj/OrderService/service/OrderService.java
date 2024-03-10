package com.vj.OrderService.service;

import com.vj.OrderService.model.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}

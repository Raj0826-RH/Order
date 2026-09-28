package com.example.demo.service;


import java.util.List;

import com.example.demo.entity.OrderEntity;


public interface OrderService {

	
		OrderEntity createOrder(OrderEntity order);
         List<OrderEntity> getAllOrders();
         OrderEntity getOrderById(Long id);

         OrderEntity updateOrder(Long id, OrderEntity order);

         void deleteOrder(Long id);
}

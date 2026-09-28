package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.OrderEntity;
import com.example.demo.execption.OrderNotFoundException;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    
    public OrderEntity createOrder(OrderEntity order) {
     
    	Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        order.setCreatedAt(currentTime);
        order.setUpdatedAt(currentTime);
        OrderEntity savedOrder = orderRepository.save(order);

        return savedOrder;
    }
    
    public List<OrderEntity> getAllOrders(){
    	List<OrderEntity> orders = orderRepository.findAll();
    	return orders;
    }
    
    public List<OrderEntity> getOrderById() {


        List<OrderEntity> orders = orderRepository.findAll();


        return orders;
    }

    
    public OrderEntity getOrderById(Long id) {


        return orderRepository.findById(id)
                .orElseThrow(() -> {


                    return new OrderNotFoundException(
                            "Order not found with ID: " + id);
                });
    }

   
    public OrderEntity updateOrder(Long id, OrderEntity order) {


        OrderEntity existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> {


                    return new OrderNotFoundException(
                            "Order not found with ID: " + id);
                });

        existingOrder.setCustomer_id(order.getCustomer_id());
        existingOrder.setProductCode(order.getProductCode());
        existingOrder.setQuality(order.getQuality());
        existingOrder.setAmount(order.getAmount());
        existingOrder.setstatus(order.getstatus());
        existingOrder.setUpdatedBy(order.getUpdatedBy());
        existingOrder.setUpdatedAt(
                new Timestamp(System.currentTimeMillis())
        );

        OrderEntity updatedOrder =
                orderRepository.save(existingOrder);


        return updatedOrder;
    }

  
    public void deleteOrder(Long id) {


        if (!orderRepository.existsById(id)) {


            throw new OrderNotFoundException(
                    "Order not found with ID: " + id);
        }

        orderRepository.deleteById(id);

    }
}
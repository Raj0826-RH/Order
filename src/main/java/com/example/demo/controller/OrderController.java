package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OrderEntity;
import com.example.demo.service.OrderService;
import com.example.demo.service.OrderServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private OrderServiceImpl orderserviceimpl;

	public OrderController(OrderServiceImpl orderservice) {
		this.orderserviceimpl = orderservice; // constructor injection
	}

	@PostMapping
	public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order) {
		// log.info("Order creating");
		return new ResponseEntity<>(orderserviceimpl.createOrder(order), HttpStatus.CREATED);
	};

	@GetMapping
	public ResponseEntity<List<OrderEntity>> getAllOrders() {

		return ResponseEntity.ok(orderserviceimpl.getAllOrders());
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderEntity> getOrderById(@PathVariable Long id) {

		return ResponseEntity.ok(orderserviceimpl.getOrderById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrderEntity> updateOrder(@PathVariable Long id, @RequestBody OrderEntity order) {

		OrderEntity updatedOrder = orderserviceimpl.updateOrder(id, order);

		return ResponseEntity.ok(updatedOrder);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long id) {

		orderserviceimpl.deleteOrder(id);

		return ResponseEntity.ok("Order deleted successfully");
	}

}

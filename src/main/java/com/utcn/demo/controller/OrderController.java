package com.utcn.demo.controller;

import com.utcn.demo.entity.Order;
import com.utcn.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/orders")
@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getAll")
    public List<Order> retrieveAllOrders(){
        return orderService.retrieveOrder();
    }

    @PostMapping("/insert")
    public Order insertOrder(@RequestBody Order order){
        return orderService.insertOrder(order);
    }

    @DeleteMapping("/deleteById")
    public void deleteOrderById(@RequestParam int id){
        orderService.deleteOrderById(id);
    }

    @GetMapping("/getOrder")
    public ResponseEntity<Order> findOrderById(@RequestParam int orderId) {
        try {
            Order order = orderService.findOrderById(orderId);
            return ResponseEntity.ok(order);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Or any other appropriate error response
        }
    }
}

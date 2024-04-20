package com.utcn.demo.controller;

import com.utcn.demo.entity.Order;
import com.utcn.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getAllOrders")
    public List<Order> retrieveAllOrders(){
        return orderService.retrieveOrder();
    }

    @PostMapping("/insertOrder")
    public Order insertOrder(@RequestBody Order order){
        return orderService.insertOrder(order);
    }

    @DeleteMapping("/deleteOrderById")
    public void deleteOrderById(@RequestParam int id){
        orderService.deleteOrderById(id);
    }
}

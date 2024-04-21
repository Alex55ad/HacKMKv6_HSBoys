package com.utcn.demo.controller;

import com.utcn.demo.entity.Order;
import com.utcn.demo.entity.OrderProduct;
import com.utcn.demo.entity.Product;
import com.utcn.demo.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RequestMapping("/orderProducts")
@RestController
@CrossOrigin
public class OrderProductController {
    @Autowired
    private OrderProductService orderProductService;

    @GetMapping("/getAll")
    public List<OrderProduct> retrieveAllOrderProducts(){
        return orderProductService.retrieveOrderProducts();
    }

    @PostMapping("/insert")
    public OrderProduct insertOrderProduct(@RequestBody OrderProduct orderProduct){
        return orderProductService.insertOrderProduct(orderProduct);
    }
    @DeleteMapping("/deleteById")
    public void deleteOrderProductById(@RequestParam int id){
        orderProductService.deleteOrderProductById(id);
    }

}

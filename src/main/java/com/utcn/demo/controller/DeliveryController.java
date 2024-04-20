package com.utcn.demo.controller;

import com.utcn.demo.entity.Delivery;
import com.utcn.demo.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/delivery")
@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/getAll")
    public List<Delivery> retrieveAllDeliveries() {
        return deliveryService.retrieveDeliveries();
    }

    @PostMapping("/insert")
    public Delivery insertDelivery(@RequestBody Delivery delivery) {
        return deliveryService.insertDelivery(delivery);
    }

    @DeleteMapping("/deleteById")
    public void deleteDeliveryById(@RequestParam int id) {
        deliveryService.deleteDeliveryById(id);
    }

    @PostMapping("/createForOrderInProgress")
    public void createDeliveryForOrderInProgress(@RequestParam int orderId) {
        deliveryService.createDeliveryForOrderInProgress(orderId);
    }
}


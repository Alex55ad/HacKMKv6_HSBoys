package com.utcn.demo.controller;

import com.utcn.demo.entity.OrderReview;
import com.utcn.demo.service.OrderReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orderReview")
@RestController
@CrossOrigin
public class OrderReviewController {

    @Autowired
    private OrderReviewService orderReviewService;

    @GetMapping("/getAll")
    public List<OrderReview> retrieveAllOrderReviews() {
        return orderReviewService.retrieveOrderReviews();
    }

    @PostMapping("/insert")
    public OrderReview insertOrderReview(@RequestBody OrderReview orderReview) {
        return orderReviewService.insertOrderReview(orderReview);
    }

    @DeleteMapping("/deleteById")
    public void deleteOrderReviewById(@RequestParam int id) {
        orderReviewService.deleteOrderReviewById(id);
    }
}

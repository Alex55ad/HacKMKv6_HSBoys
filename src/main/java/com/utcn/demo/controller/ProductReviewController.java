package com.utcn.demo.controller;

import com.utcn.demo.entity.ProductReview;
import com.utcn.demo.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/productReview")
@RestController
@CrossOrigin
public class ProductReviewController {

    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping("/getAll")
    public List<ProductReview> retrieveAllProductReviews() {
        return productReviewService.retrieveProductReviews();
    }

    @PostMapping("/insert")
    public ProductReview insertProductReview(@RequestBody ProductReview productReview) {
        return productReviewService.insertProductReview(productReview);
    }

    @DeleteMapping("/deleteById")
    public void deleteProductReviewById(@RequestParam int id) {
        productReviewService.deleteProductReviewById(id);
    }
}

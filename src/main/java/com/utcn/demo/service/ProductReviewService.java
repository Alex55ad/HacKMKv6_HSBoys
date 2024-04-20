package com.utcn.demo.service;

import com.utcn.demo.entity.ProductReview;
import com.utcn.demo.repository.ProductReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ProductReviewService {

    @Autowired
    private ProductReviewRepository productReviewRepository;

    public List<ProductReview> retrieveProductReviews() {
        return productReviewRepository.findAll();
    }

    public ProductReview insertProductReview(ProductReview productReview) {
        return productReviewRepository.save(productReview);
    }

    public void deleteProductReviewById(int id) {
        Optional<ProductReview> optionalProductReview = productReviewRepository.findById(id);
        if (optionalProductReview.isEmpty())
            throw new RuntimeException("Product review not found");
        else
            productReviewRepository.deleteById(id);
    }
}
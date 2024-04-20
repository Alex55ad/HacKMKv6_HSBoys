package com.utcn.demo.repository;

import com.utcn.demo.entity.Product;
import com.utcn.demo.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {
    List<ProductReview> findByProduct(Product product);
}

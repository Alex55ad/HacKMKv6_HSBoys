package com.utcn.demo.service;

import com.utcn.demo.entity.OrderReview;
import com.utcn.demo.repository.OrderReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderReviewService {

    @Autowired
    private OrderReviewRepository orderReviewRepository;

    public List<OrderReview> retrieveOrderReviews() {
        return orderReviewRepository.findAll();
    }

    public OrderReview insertOrderReview(OrderReview orderReview) {
        return orderReviewRepository.save(orderReview);
    }

    public void deleteOrderReviewById(int id) {
        Optional<OrderReview> optionalOrderReview = orderReviewRepository.findById(id);
        if (optionalOrderReview.isEmpty())
            throw new RuntimeException("Order review not found");
        else
            orderReviewRepository.deleteById(id);
    }

}
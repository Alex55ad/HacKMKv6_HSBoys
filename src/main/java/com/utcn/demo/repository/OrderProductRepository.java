package com.utcn.demo.repository;

import com.utcn.demo.entity.Order;
import com.utcn.demo.entity.OrderProduct;
import com.utcn.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
    OrderProduct findByOrderAndProduct(Order order, Product product);

    Optional<List<OrderProduct>> findByOrder(Order order);
}

package com.utcn.demo.service;

import com.utcn.demo.entity.BusinessRegister;
import com.utcn.demo.entity.Order;
import com.utcn.demo.entity.OrderProduct;
import com.utcn.demo.entity.Product;
import com.utcn.demo.repository.OrderProductRepository;
import com.utcn.demo.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderProductService {
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderProduct> retrieveOrderProducts() {
        return(List<OrderProduct>) this.orderProductRepository.findAll();
    }

    public OrderProduct insertOrderProduct(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }

    public void deleteOrderProductById(int id) {
        if(this.orderProductRepository.findById(id).isEmpty())
            throw new RuntimeException("User not found");
        else
            this.orderProductRepository.deleteById(id);
    }
  public List<OrderProduct> findOrderProductsByOrderId(int orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()) {
            Optional<List<OrderProduct>> optional = orderProductRepository.findByOrder(optionalOrder.get());
            if(optional.isPresent()){
                return optional.get();
            }
            else throw new RuntimeException("No orderproducts for order");
        }
        else throw new RuntimeException("Order not found");
    }

}

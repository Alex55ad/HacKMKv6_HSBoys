package com.utcn.demo.service;

import com.utcn.demo.entity.Delivery;
import com.utcn.demo.entity.Order;
import com.utcn.demo.entity.Vehicle;
import com.utcn.demo.repository.DeliveryRepository;
import com.utcn.demo.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private VehicleService vehicleService;

    public List<Delivery> retrieveDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery insertDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public void deleteDeliveryById(int id) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(id);
        if (optionalDelivery.isEmpty())
            throw new RuntimeException("Delivery not found");
        else
            deliveryRepository.deleteById(id);
    }

    private static int timeFrame(){
        Random random = new Random();
        return random.nextInt(2) + 1;
    }

    public LocalDateTime calculateDeliveryDate(int orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            LocalDateTime orderDate = optionalOrder.get().getDate();
            LocalDateTime deliveryDate = orderDate; // Assuming initial delivery in 1 day

            // Calculate delivery date considering weekends
            for (int i = 0; i < timeFrame(); i++) {
                deliveryDate = deliveryDate.plusDays(1);
                if (deliveryDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
                    deliveryDate = deliveryDate.plusDays(2); // Skip Saturday
                } else if (deliveryDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    deliveryDate = deliveryDate.plusDays(1); // Skip Sunday
                }
            }
            return deliveryDate;
        } else {
            throw new RuntimeException("Order or delivery not found");
        }
    }

    public void createDeliveryForOrderInProgress(int orderId) {
        // Retrieve vehicle name and registration
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Vehicle vehicle = vehicleService.getRandomVehicle();
            // Calculate delivery date (assuming a method like calculateDeliveryDate() exists)
            LocalDateTime calculatedDeliveryDate = calculateDeliveryDate(orderId);

            // Create and save the delivery
            Delivery delivery = new Delivery();
            Order order = optionalOrder.get();
            delivery.setOrder(order);
            delivery.setVehicle(vehicle);
            delivery.setDeliveryDate(calculatedDeliveryDate);
            delivery.setStatus("In Progress");
            deliveryRepository.save(delivery);
        }
        else throw new RuntimeException("Order not found");
    }

}

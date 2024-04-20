package com.utcn.demo.service;

import com.utcn.demo.entity.Delivery;
import com.utcn.demo.repository.DeliveryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

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
}

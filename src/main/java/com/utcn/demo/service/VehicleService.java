package com.utcn.demo.service;
import com.utcn.demo.entity.Vehicle;
import com.utcn.demo.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> retrieveVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle insertVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicleById(int id) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isEmpty())
            throw new RuntimeException("Vehicle not found");
        else
            vehicleRepository.deleteById(id);
    }

}
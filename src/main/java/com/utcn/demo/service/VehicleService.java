package com.utcn.demo.service;
import com.utcn.demo.entity.Vehicle;
import com.utcn.demo.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

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

    public Vehicle getRandomVehicle() {
        List<Vehicle> vehicles = vehicleRepository.findAll();

        if (!vehicles.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(vehicles.size()) + 1;

            Vehicle randomVehicle = vehicles.get(randomIndex);
            return randomVehicle;
        } else {
            throw new RuntimeException("No vehicles found in the database");
        }
    }

}
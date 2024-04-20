package com.utcn.demo.controller;

import com.utcn.demo.entity.Vehicle;
import com.utcn.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/vehicle")
@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/getAll")
    public List<Vehicle> retrieveAllVehicles() {
        return vehicleService.retrieveVehicles();
    }

    @PostMapping("/insert")
    public Vehicle insertVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.insertVehicle(vehicle);
    }

    @DeleteMapping("/deleteById")
    public void deleteVehicleById(@RequestParam int id) {
        vehicleService.deleteVehicleById(id);
    }
}

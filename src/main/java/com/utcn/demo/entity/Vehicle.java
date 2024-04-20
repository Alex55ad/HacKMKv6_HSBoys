package com.utcn.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="Vehicles")
public class Vehicle {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="type")
    private String type;

    @Column(name= "last_maintenance")
    private LocalDateTime last_maintenance;

    @Column(name = "registration_number")
    private String registration;

    public Vehicle() {
    }

    public Vehicle(int id, String type, LocalDateTime last_maintenance, String registration) {
        this.id = id;
        this.type = type;
        this.last_maintenance = last_maintenance;
        this.registration = registration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getLast_maintenance() {
        return last_maintenance;
    }

    public void setLast_maintenance(LocalDateTime last_maintenance) {
        this.last_maintenance = last_maintenance;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}

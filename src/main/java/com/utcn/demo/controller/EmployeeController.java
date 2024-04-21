package com.utcn.demo.controller;

import com.utcn.demo.entity.Employee;
import com.utcn.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public List<Employee> retrieveAllEmployees() {
        return employeeService.retrieveEmployees();
    }

    @PostMapping("/insert")
    public Employee insertEmployee(@RequestBody Employee employee) {
        return employeeService.insertEmployee(employee);
    }

    @DeleteMapping("/deleteById")
    public void deleteEmployeeById(@RequestParam int id) {
        employeeService.deleteEmployeeById(id);
    }
}


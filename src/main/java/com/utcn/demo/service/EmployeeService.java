package com.utcn.demo.service;

import com.utcn.demo.entity.Employee;
import com.utcn.demo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> retrieveEmployees() {
        return employeeRepository.findAll();
    }

    public Employee insertEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty())
            throw new RuntimeException("Employee not found");
        else
            employeeRepository.deleteById(id);
    }


}
package com.utcn.demo.controller;

import com.utcn.demo.entity.BusinessRegister;
import com.utcn.demo.service.BusinessRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/business")
@RestController
@CrossOrigin
public class BusinessRegisterController {

    @Autowired
    private BusinessRegisterService businessRegisterService;

    @GetMapping("/getAll")
    public List<BusinessRegister> retrieveAllBusinessRegisters() {
        return businessRegisterService.retrieveBusinessRegisters();
    }

    @PostMapping("/insert")
    public BusinessRegister insertBusinessRegister(@RequestBody BusinessRegister businessRegister) {
        return businessRegisterService.insertBusinessRegister(businessRegister);
    }

    @DeleteMapping("/deleteById")
    public void deleteBusinessRegisterById(@RequestParam int id) {
        businessRegisterService.deleteBusinessRegisterById(id);
    }
}

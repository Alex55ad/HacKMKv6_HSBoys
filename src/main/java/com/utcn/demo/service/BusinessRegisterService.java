package com.utcn.demo.service;

import com.utcn.demo.entity.BusinessRegister;
import com.utcn.demo.repository.BusinessRegisterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class BusinessRegisterService {

    @Autowired
    private BusinessRegisterRepository businessRegisterRepository;

    public List<BusinessRegister> retrieveBusinessRegisters() {
        return businessRegisterRepository.findAll();
    }

    public BusinessRegister insertBusinessRegister(BusinessRegister businessRegister) {
        return businessRegisterRepository.save(businessRegister);
    }

    public void deleteBusinessRegisterById(int id) {
        Optional<BusinessRegister> optionalBusinessRegister = businessRegisterRepository.findById(id);
        if (optionalBusinessRegister.isEmpty())
            throw new RuntimeException("Business register not found");
        else
            businessRegisterRepository.deleteById(id);
    }

    public BusinessRegister findBusinessRegisterById(int id) {
        Optional<BusinessRegister> optional = businessRegisterRepository.findById(id);
        if(optional.isPresent()){
            return  optional.get();
        }
        else throw new RuntimeException("BusinessRegisterNotFound");
    }


}
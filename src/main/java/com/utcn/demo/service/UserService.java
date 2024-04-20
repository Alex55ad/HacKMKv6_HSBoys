package com.utcn.demo.service;

import com.utcn.demo.entity.User;
import com.utcn.demo.repository.UserRepository;
import com.utcn.demo.service.validations.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    UserValidator userValidator = new UserValidator();
    @Autowired
    private UserRepository userRepository;

    public List<User> retrieveUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    public User insertUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUserById(int id) {
            if(userRepository.findById(id).isEmpty())
                throw new RuntimeException("User not found");
            else
                this.userRepository.deleteById(id);
    }

    public User loginUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            //if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
            // }
        }
        return null;
    }

    public User createUser(User user) {
        if(!userValidator.validateUsername(user.getUsername()))
            throw new RuntimeException("Invalid username");
        if(!userValidator.validatePassword(user.getPassword()).equals("Password OK")) {
            if (userValidator.validatePassword(user.getPassword()).equals("Password too short!"))
                throw new RuntimeException("Password too short");
            if(userValidator.validatePassword(user.getPassword()).equals("Password must contain at least one special character!"))
                throw new RuntimeException("Password does not contain special characters");
            if (userValidator.validatePassword(user.getPassword()).equals("Password must contain at least one digit!"))
                throw new RuntimeException("Password does not contain any digits");
        }
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        // String encryptedPassword = passwordEncoder.encode(user.getPassword());
        // user.setPassword(encryptedPassword);
        return this.userRepository.save(user);
    }

}

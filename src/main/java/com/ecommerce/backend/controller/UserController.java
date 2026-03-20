package com.ecommerce.backend.controller;

import com.ecommerce.backend.entity.Users;
import com.ecommerce.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    UserController (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return userRepository.findAll();
        // For pagination
//        Page<Users> all = userRepository.findAll(PageRequest.of(0, 5));
//        return all.getContent();
    }

    @GetMapping("/{id}")
    public Users getusersById(@PathVariable String id){
        Users users = userRepository.findById(id).orElse(null);
        return users;
    }
}

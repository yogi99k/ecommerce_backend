package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.UsersDto;
import com.ecommerce.backend.entity.Users;
import com.ecommerce.backend.repository.UserRepository;
import com.ecommerce.backend.service.UsersService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UsersService usersService;

    UserController (UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<UsersDto> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UsersDto getUserById(@PathVariable String id) {
        return usersService.getUserById(id);
    }

    @PostMapping
    public UsersDto createUser(@RequestBody @Valid UsersDto userDTO) {
        return usersService.createUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        usersService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public UsersDto updateUser(@PathVariable String id,
                               @RequestBody UsersDto userDTO) {
        return usersService.updateUserById(id, userDTO);
    }

    //If both name and city are given in filter ?
    //Need to optimize the search
    @GetMapping("/search")
    public List<UsersDto> searchByName(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city) {
        if (name != null) {
            return usersService.searchByName(name);
        } else if (city != null) {
            return usersService.searchByCity(city);
        } else {
            return usersService.getAllUsers();
        }
    }

    @GetMapping("/filter")
    public List<UsersDto> filterByGender(@RequestParam
                                             @Validated
                                             @NotBlank(message="Gender cannot be empty")
                                             String gender){
        return usersService.filterByGender(gender);
    }

    @GetMapping("/filter/city")
    public List<UsersDto> filterByCity(@RequestParam String city){
        return usersService.filterByCity(city);
    }

}

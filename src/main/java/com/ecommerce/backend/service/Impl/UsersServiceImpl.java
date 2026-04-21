package com.ecommerce.backend.service.Impl;

import com.ecommerce.backend.dto.UsersDto;
import com.ecommerce.backend.entity.Users;
import com.ecommerce.backend.mapper.UsersMapper;
import com.ecommerce.backend.repository.UserRepository;
import com.ecommerce.backend.service.UsersService;
//import org.springdoc.core.converters.models.Sort;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

    public UsersServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public List<UsersDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UsersMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto getUserById(String id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return UsersMapper.toDto(user);
    }

    @Override
    public UsersDto createUser(UsersDto userDTO) {
        Users user = UsersMapper.toEntity(userDTO);
        Users savedUser = userRepository.save(user);
        return UsersMapper.toDto(savedUser);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public UsersDto updateUserById(String id, UsersDto userDTO) {
        Users existingUser = userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            return null;
        }

        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setCity(userDTO.getCity());
        existingUser.setSignupDate(userDTO.getSignup_date());

        Users updatedUser = userRepository.save(existingUser);
        return UsersMapper.toDto(updatedUser);
    }

    @Override
    public List<UsersDto> searchByName(String name) {
        return userRepository.findByName(name)
                .stream()
                .map(UsersMapper::toDto)
                .toList();
    }

    @Override
    public List<UsersDto> searchByCity(String name) {
        return userRepository.findByCity(name)
                .stream()
                .map(UsersMapper::toDto)
                .toList();
    }

    @Override
    public List<UsersDto> filterByGender(String gender) {
        return userRepository.findByGender(gender)
                .stream()
                .map(UsersMapper::toDto)
                .toList();
    }

    @Override
    public List<UsersDto> filterByCity(String city){
        return userRepository.findByCity(city)
                .stream()
                .map(UsersMapper::toDto)
                .toList();
    }

    @Override
    public List<UsersDto> getSortBySignupDate(String direction) {
//        Sort sort;
//        if ("asc".equalsIgnoreCase(direction)) {
//            sort = Sort.by("signupDate").ascending();
//        } else {
//            sort = Sort.by("signupDate").descending();
//        }
        Sort orders = direction.equalsIgnoreCase("desc") ?
                Sort.by("signupDate").descending() :
                Sort.by("signupDate").ascending();

        return userRepository.findAll(orders)
                .stream()
                .map(UsersMapper::toDto)
                .toList();
    }
}

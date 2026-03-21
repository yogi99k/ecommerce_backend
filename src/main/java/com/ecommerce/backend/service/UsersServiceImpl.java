package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.UsersDto;
import com.ecommerce.backend.entity.Users;
import com.ecommerce.backend.mapper.UsersMapper;
import com.ecommerce.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

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
        Users user = userRepository.findById(id).orElse(null);
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
}

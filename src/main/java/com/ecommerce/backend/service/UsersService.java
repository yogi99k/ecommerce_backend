package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.UsersDto;
import com.ecommerce.backend.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {

    List<UsersDto> getAllUsers(int page, int size);

    UsersDto getUserById(String id);

    UsersDto createUser(UsersDto userDTO);

    void deleteUser(String id);

    UsersDto updateUserById(String id, UsersDto userDTO);

    List<UsersDto> searchByName(String name);

    List<UsersDto> searchByCity(String name);

    List<UsersDto> filterByGender(String gender);

    List<UsersDto> filterByCity(String city);

    List<UsersDto> getSortBySignupDate(String direction);

    List<UsersDto> getDynamicAPIREQ1(int page, int size);
}

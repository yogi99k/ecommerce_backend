package com.ecommerce.backend.mapper;

import com.ecommerce.backend.dto.UsersDto;
import com.ecommerce.backend.entity.Users;

public class UsersMapper {
    //the method to convert Users entity to UsersDto, i.e. to convert the data from the database
    // to the format that we want to return to the client
    public static UsersDto toDto(Users users){

        if (users == null) return null;
        UsersDto usersDto = new UsersDto();
        usersDto.setUserId(users.getUserId());
        usersDto.setName(users.getName());
        usersDto.setEmail(users.getEmail());
        usersDto.setCity(users.getCity());
        usersDto.setSignup_date(users.getSignup_date());

        return usersDto;
    }

    //the method to convert UsersDto to Users entity,
    // i.e. to convert the data from the format that we receive from the client
    public static Users toEntity(UsersDto usersDto){

        if (usersDto == null) return null;
        Users users = new Users();
        users.setUserId(usersDto.getUserId());
        users.setName(usersDto.getName());
        users.setEmail(usersDto.getEmail());
        users.setCity(usersDto.getCity());
        users.setSignup_date(usersDto.getSignup_date());

        return users;
    }
}

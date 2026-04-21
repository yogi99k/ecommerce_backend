package com.ecommerce.backend.repository;

import com.ecommerce.backend.dto.UsersDto;
import com.ecommerce.backend.entity.Users;
import org.apache.logging.log4j.simple.internal.SimpleProvider;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    List<Users> findByName(String name);
    List<Users> findByCity(String name);

    List<Users> findByGender(String gender);

    List<Users> findAll(Sort sort);
}

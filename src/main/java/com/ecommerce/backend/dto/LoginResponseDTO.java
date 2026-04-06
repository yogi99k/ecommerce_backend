package com.ecommerce.backend.dto;

public record LoginResponseDTO(String message, UserDTO user,String jwtToken) {

}

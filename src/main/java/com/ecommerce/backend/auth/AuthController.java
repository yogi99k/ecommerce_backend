package com.ecommerce.backend.auth;

import com.ecommerce.backend.dto.LoginDTO;
import com.ecommerce.backend.dto.LoginResponseDTO;
import com.ecommerce.backend.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/login/public")
    public ResponseEntity<LoginResponseDTO> apiLogin(LoginDTO loginDTO){
            var userDTO = new UserDTO();
        return ResponseEntity.status(HttpStatus.OK)
                .body(new LoginResponseDTO(HttpStatus.OK.getReasonPhrase(),userDTO,null));
    }
}

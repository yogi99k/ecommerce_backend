package com.ecommerce.backend.client.controller;

import com.ecommerce.backend.client.service.RestClientTodoService;
import com.ecommerce.backend.dto.TodoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final RestClientTodoService restClientTodoService;

    public TodoController(RestClientTodoService restClientTodoService) {
        this.restClientTodoService = restClientTodoService;
    }

    @GetMapping
    ResponseEntity<List<TodoDTO>> findAll(){
        return ResponseEntity.ok(restClientTodoService.findAll());
    }
}

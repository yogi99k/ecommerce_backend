package com.ecommerce.backend.client.service;

import com.ecommerce.backend.dto.TodoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class RestClientTodoService {
    private final RestClient restClient;
    private static final String TODO_API="todos";

    public RestClientTodoService(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://jsonplaceholder.typicode.com/")
                .defaultHeader("Accept","application/json")
                .build();
    }

    public List<TodoDTO> findAll(){
        return restClient.get()
                .uri(TODO_API)
                .retrieve()
                .onStatus(HttpStatusCode::isError, (req,res)->
                        new IllegalStateException("Failed to fetch todo's"))
                .body(new ParameterizedTypeReference<>(){});
    }

    public TodoDTO findById(Long id){
        return restClient.get()
                .uri(TODO_API + "/{id}",id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (req,res)->
                        new IllegalStateException("Todo not found of id"+id))
                .body(TodoDTO.class);
    }
}

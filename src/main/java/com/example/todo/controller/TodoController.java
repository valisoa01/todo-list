package com.example.todo.controller;

import com.example.todo.rest.TodoDto;
import com.example.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoDto> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public TodoDto getTodoById(@PathVariable UUID id) {
        return todoService.getTodoById(id);
    }

    @PutMapping
    public List<TodoDto> putTodos(@RequestBody List<TodoDto> todos) {
        return todoService.putTodos(todos);
    }
}

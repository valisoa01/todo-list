package com.example.todo.service;

import com.example.todo.exception.TodoNotFoundException;
import com.example.todo.rest.TodoDto;

import java.util.List;
import java.util.UUID;

public interface TodoService {

    List<TodoDto> getAllTodos();

    /**
     * @throws TodoNotFoundException if no todo exists with the given id
     */
    TodoDto getTodoById(UUID id);

    List<TodoDto> putTodos(List<TodoDto> todos);
}

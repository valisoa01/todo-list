package com.example.todo.service;

import com.example.todo.exception.TodoNotFoundException;
import com.example.todo.mapper.TodoMapper;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.rest.TodoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    @Override
    public List<TodoDto> getAllTodos() {
        return todoRepository.findAll()
                .stream()
                .map(todoMapper::toDto)
                .toList();
    }

    @Override
    public TodoDto getTodoById(UUID id) {
        return todoRepository.findById(id)
                .map(todoMapper::toDto)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @Override
    @Transactional
    public List<TodoDto> putTodos(List<TodoDto> todos) {
        return todos.stream()
                .map(this::upsert)
                .map(todoMapper::toDto)
                .toList();
    }

    private Todo upsert(TodoDto dto) {
        UUID id = dto.id() != null ? dto.id() : UUID.randomUUID();

        Todo entity = todoRepository.findById(id)
                .map(existing -> {
                    todoMapper.updateEntity(existing, dto);
                    return existing;
                })
                .orElseGet(() -> todoMapper.toNewEntity(new TodoDto(
                        id, dto.title(), dto.description(), dto.completed(), null, null)));

        return todoRepository.save(entity);
    }
}

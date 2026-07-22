package com.example.todo.mapper;

import com.example.todo.model.Todo;
import com.example.todo.rest.TodoDto;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public TodoDto toDto(Todo todo) {
        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted(),
                todo.getCreatedAt(),
                todo.getUpdatedAt()
        );
    }

    public Todo toNewEntity(TodoDto dto) {
        return Todo.builder()
                .id(dto.id())
                .title(dto.title())
                .description(dto.description())
                .completed(dto.completed())
                .build();
    }

    public void updateEntity(Todo entity, TodoDto dto) {
        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setCompleted(dto.completed());
    }
}

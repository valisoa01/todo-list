package com.example.todo.rest;

import java.time.OffsetDateTime;
import java.util.UUID;

public class TodoDto {
    UUID id;
    String title;
    String description;
    boolean completed;
    OffsetDateTime createdAt;
    OffsetDateTime updatedAt;

}

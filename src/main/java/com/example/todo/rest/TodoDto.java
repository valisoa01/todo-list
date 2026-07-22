package com.example.todo.rest;

import java.time.OffsetDateTime;
import java.util.UUID;

public record TodoDto(
        UUID id,
        String title,
        String description,
        boolean completed,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}

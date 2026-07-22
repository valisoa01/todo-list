DELETE FROM todo;

INSERT INTO todo (id, title, description, is_completed, created_at, updated_at)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'Learn Spring Boot',
     'Understand controllers, services, repositories', false, now(), now()),
    ('22222222-2222-2222-2222-222222222222', 'Practice clean architecture',
     'Separate domain from persistence', true, now(), now());
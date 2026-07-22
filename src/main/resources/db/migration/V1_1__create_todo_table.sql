CREATE TABLE todo (
                      id            UUID PRIMARY KEY,
                      title         VARCHAR(255) NOT NULL,
                      description   TEXT,
                      is_completed  BOOLEAN NOT NULL DEFAULT FALSE,
                      created_at    TIMESTAMPTZ NOT NULL DEFAULT now(),
                      updated_at    TIMESTAMPTZ NOT NULL DEFAULT now()
);
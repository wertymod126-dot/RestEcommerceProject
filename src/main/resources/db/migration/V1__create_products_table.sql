-- Flyway runs each V<number>__<name>.sql file once, in order, and records it.
-- Never edit a migration that has already run: add a new V2__..., V3__... instead.

CREATE TABLE products (
                          id             BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                          name           VARCHAR(400)   NOT NULL,
                          description    TEXT,
                          price          DECIMAL(10, 2) NOT NULL,
                          image_url      VARCHAR(400)   NOT NULL,
                          stock_quantity INTEGER        NOT NULL DEFAULT 0,
                          active         BOOLEAN        NOT NULL DEFAULT false,
                          created_at     TIMESTAMP      NOT NULL,
                          updated_at     TIMESTAMP      NOT NULL,
                          version        BIGINT         NOT NULL DEFAULT 0
);

-- Flyway runs each V<number>__<name>.sql file once, in order, and records it.
-- Never edit a migration that has already run: add a new V2__..., V3__... instead.

CREATE TABLE products
(
    id             BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name           VARCHAR(255)   NOT NULL,
    description    VARCHAR(2000),
    price          NUMERIC(12, 2) NOT NULL CHECK (price >= 0),
    stock_quantity INTEGER        NOT NULL CHECK (stock_quantity >= 0),
    created_at     TIMESTAMPTZ    NOT NULL,
    updated_at     TIMESTAMPTZ    NOT NULL
);

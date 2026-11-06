CREATE TABLE products (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,
    name VARCHAR(400) NOT NULL,
    description TEXT,
    price decimal(10,2) NOT NULL ,
    image_url VARCHAR(400) NOT NULL ,
    stock_quantity INTEGER NOT NULL ,
    active BOOLEAN NOT NULL DEFAULT false,
    created_at timestamp NOT NULL ,
    updated_at timestamp NOT NULL ,
    version BIGINT DEFAULT 0
);
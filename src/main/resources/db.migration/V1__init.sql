CREATE TABLE permissions
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE user_permissions
(
    user_id       BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, permission_id),
    CONSTRAINT fk_user
        FOREIGN KEY (user_id) REFERENCES users (id)
            ON DELETE CASCADE,
    CONSTRAINT fk_permission
        FOREIGN KEY (permission_id) REFERENCES permissions (id)
            ON DELETE CASCADE
);

CREATE TABLE authors
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE categories
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE books
(
    id        BIGSERIAL PRIMARY KEY,
    title     VARCHAR(255) NOT NULL,
    year      INT,
    author_id BIGINT,
    CONSTRAINT fk_book_author
        FOREIGN KEY (author_id) REFERENCES authors (id)
            ON DELETE SET NULL
);

CREATE TABLE book_categories
(
    book_id     BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (book_id, category_id),
    CONSTRAINT fk_book
        FOREIGN KEY (book_id) REFERENCES books (id)
            ON DELETE CASCADE,
    CONSTRAINT fk_category
        FOREIGN KEY (category_id) REFERENCES categories (id)
            ON DELETE CASCADE
);
INSERT INTO permissions (name)
VALUES ('ROLE_USER'),
       ('ROLE_USER');

INSERT INTO users (username, password)
VALUES ('user1', '$2a$10$testpassworduser'),
       ('user2', '$2a$10$testpasswordadmin');


INSERT INTO authors (name)
VALUES ('Abai Kunanbaev'),
       ('Ahmet Baitursinuli'),
       ('Pepe Shneine Fa');

INSERT INTO categories (name)
VALUES ('Dystopia'),
       ('Classic'),
       ('Fantasy');

INSERT INTO books (title, year, author_id)
VALUES ('ABC', 1949, 1),
       ('QWERTY', 1866, 2),
       ('IAdad', 1996, 3);

INSERT INTO book_categories (book_id, category_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);

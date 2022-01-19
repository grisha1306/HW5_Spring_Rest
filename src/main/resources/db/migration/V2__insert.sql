INSERT INTO books (name, price, num, warehouse)
VALUES
    ('Java', 399.99, 3, 'Sovetckiy'),
    ('Java', 399.99, 22, 'Priokskiy'),
    ('Java', 399.99, 13, 'Leninskiy'),
    ('Java', 399.99, 5, 'Kanavinskiy'),
    ('SQL', 21000, 13, 'Kanavinskiy'),
    ('SQL', 20500, 12, 'Leninskiy'),
    ('Spring Boot', 937.49, 1, 'Sormovskiy'),
    ('Spring Boot', 937.49, 22, 'Priokskiy'),
    ('Windows Start', 1000, 2, 'Avtozavodskiy'),
    ('Spring Boot', 1038.49, 13, 'Kanavinskiy');


INSERT INTO customer (surname, discount, area)
VALUES
    ('Ivanov', 13 ,'Sovetskiy'),
    ('Petrov', 11 ,'Sovetskiy'),
    ('Bolshakov', 5 ,'Priokskiy'),
    ('Dmitriev', 17 ,'Avtozavodskiy'),
    ('Antonov', 7 ,'Priokskiy'),
    ('Sidorod', 10 ,'Nizhegorodskiy'),
    ('Potapkin', 6 ,'Nizhegorodskiy'),
    ('Elesin', 3 ,'Avtozavodskiy'),
    ('Ovdina', 13 ,'Leninskiy');


INSERT INTO store (name, commission, area)
VALUES
    ('Mir knig', 20 ,'Sovetskiy'),
    ('Book store 1', 15 ,'Sovetskiy'),
    ('Book store 2', 18 ,'Priokskiy'),
    ('Book store 3', 19 ,'Sormovskiy'),
    ('Book store 4', 10 ,'Avtozavodskiy'),
    ('Chitaina', 13 ,'Leninskiy');



INSERT INTO buy (customer_id, store_id, book_id, num, sum, date_buy)
VALUES
    (1, 3, 2, 2, 2500, '2022-01-08'),
    (2, 2, 6, 1, 3300, '2021-07-13'),
    (1, 1, 4, 1, 4000, '2021-06-15'),
    (3, 1, 2, 11, 1500, '2021-10-15'),
    (2, 2, 7, 2, 2000, '2021-10-31'),
    (1, 2, 5, 20, 62000, '2021-12-31'),
    (3, 3, 4, 3, 3500, '2021-03-01'),
    (1, 5, 6, 8, 5000, '2021-03-10'),
    (7, 5, 6, 8, 70000, '2021-03-22'),
    (8, 3, 2, 6, 2600, '2021-03-15'),
    (9, 3, 1, 5, 12000, '2022-01-20');


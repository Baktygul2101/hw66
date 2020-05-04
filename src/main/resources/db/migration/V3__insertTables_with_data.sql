
INSERT INTO categories (categoryName, description) VALUES ('HDD', 'Жесткие диски');
INSERT INTO categories (categoryName, description) VALUES ('Monitors', 'Мониторы');
INSERT INTO categories (categoryName, description) VALUES ('Motherboards', 'Материнские платы');
INSERT INTO categories (categoryName, description) VALUES ('DDR', 'Оперативная память');
INSERT INTO categories (categoryName, description) VALUES ('Smartphones', 'Смартфоны');

INSERT INTO brands (brandName) VALUES ('Samsung');
INSERT INTO brands (brandName) VALUES ('ASUS');
INSERT INTO brands (brandName) VALUES ('Acer');


INSERT INTO products (name, image, quantity, description, price,category_id,brand_id)
VALUES ('S4 HDD 1T, 7200rpm','photo',6,'', 127,2,3),
       ('S5 HDD 500Gb, 7200rpm', 'photo',3,'', 92,1,2),
       ('S5 HDD 500Gb, 7200rpm', 'photo',3,'', 895,5,2),
       ('S2 HDD 500Gb, 7200 rpm','',8,'', 85,4,3),
       ('S3 HDD 250Gb, 10000 rpm','',7,'', 150,3,1);

INSERT INTO categories (categoryName, description) VALUES ('Электроника', '');
INSERT INTO categories (categoryName, description) VALUES ('Товары для дома', '');
INSERT INTO categories (categoryName, description) VALUES ('Косметика', '');
INSERT INTO categories (categoryName, description) VALUES ('Транспорт', '');
INSERT INTO categories (categoryName, description) VALUES ('Смартфоны', 'Смартфоны');
INSERT INTO categories (categoryName, description) VALUES ('Спорт товары', '');
INSERT INTO categories (categoryName, description) VALUES ('Канцелярия', '');
INSERT INTO categories (categoryName, description) VALUES ('Аксессуары', '');

INSERT INTO brands (brandName) VALUES ('Samsung');
INSERT INTO brands (brandName) VALUES ('Redmi');
INSERT INTO brands (brandName) VALUES ('Acer');
INSERT INTO brands (brandName) VALUES ('Made in KG');
INSERT INTO brands (brandName) VALUES ('Toyota');
INSERT INTO brands (brandName) VALUES ('Lexus');
INSERT INTO brands (brandName) VALUES ('Bigser sport');
INSERT INTO brands (brandName) VALUES ('Nike');
INSERT INTO brands (brandName) VALUES ('Puma');
INSERT INTO brands (brandName) VALUES ('Made in Korea');
INSERT INTO brands (brandName) VALUES ('Made in China');


INSERT INTO products (name, image, quantity, description, price,category_id,brand_id)
VALUES ('Сумка м-1','bag.jpg',10,'сумка женская коричневая, кожанная, всесезонная', 2500,8,11),
       ('Сумка м-2', 'black.jpg',3,'черная гламурная сумка высокого качества, в органиченном количестве', 4000,8,10),
       ('Сумка м-3','pink.jpg',7,'', 2650,8,10),
       ('Губная помада', 'lipstick.jpg', 20,'красная помада Mac', 500,3,11),
       ('Блеск для губ','lip2.jpg',8,'увлажняющий эффект и стойкий цвет', 300,3,10),
       ('Лопата л-1','lop2.png',3,'Лопата отечественного производства', 400,2,4),
       ('Лопата л-1','lopata.jpg',7,'очень удобная лопата', 650,2,11),
        ('Мусорное ведро','musor.jpg',7,'', 150,2,11),
        ('Кроссовки м-1','n1.jpg',5,'', 3450,2,8),
        ('Кроссовки м-2','n4.jpg',8,'', 4500,2,8),
        ('Пудра','nyx.jpg',7,'', 650,3,10),
        ('Блокнот','note.jpg',7,'', 80,2,11),
        ('Ведро железное','vedro.jpg',7,'', 250,2,11),
        ('Ведро пластмассовое','vedro2.jpg',25,'', 200,2,11),
        ('Пудра м-1','powder.jpg',2,'компактная пудра', 450,3,10),
        ('Пудра м-2','p-velvet.jpg',6,'', 550,3,11),
        ('Redmi Note 8 64*4','redmi.jpg',7,'', 13000,5,2),
        ('Sumsung G20 128','t1.jpg',8,'', 30000,5,1);

--
use `myshop`;

-- make
CREATE TABLE `customers` (
     `id` int auto_increment NOT NULL,
     `email` varchar(128) NOT NULL,
     `password` varchar(128) NOT NULL,
     `name` varchar(128) NOT NULL default ' ',
     `address` varchar(128) NOT NULL,
     `phoneNumber` varchar(128) NOT NULL ,
     `enabled` boolean NOT NULL default true,
     `role` varchar(16) NOT NULL default 'USER',
     PRIMARY KEY (`id`),
     UNIQUE INDEX `email_unique` (`email` ASC)
);



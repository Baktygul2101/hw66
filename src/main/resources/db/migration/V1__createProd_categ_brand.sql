use `myshop`;

create table `products` (
 `id`  bigint(20) NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(128) NOT NULL,
 `image` VARCHAR(128) NOT NULL,
 `quantity` INT NOT NULL,
 `description` VARCHAR(128) NOT NULL,
 `price` DOUBLE NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE categories (
  id int(11) NOT NULL AUTO_INCREMENT,
  categoryName varchar(45) NOT NULL DEFAULT 'name category',
  description varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE brands (
  id int(11) NOT NULL AUTO_INCREMENT,
  brandName varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
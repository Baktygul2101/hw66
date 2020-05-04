
ALTER TABLE `products`
 ADD COLUMN `category_id` INT NOT NULL after `price`,
 ADD CONSTRAINT `fk_product__categories`
 FOREIGN KEY (`category_id`)
 REFERENCES `categories` (`id`);

 ALTER TABLE `products`
 ADD COLUMN `brand_id` INT NOT NULL after `category_id`,
 ADD CONSTRAINT `fk_product__brands`
 FOREIGN KEY (`brand_id`)
 REFERENCES `brands` (`id`);

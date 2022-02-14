CREATE TABLE if  not exists `phoneshop`.`promotion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NULL,
  `variant_id` INT NULL,
  `price` DOUBLE NULL,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  PRIMARY KEY (`id`));

drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);
create table IF NOT EXISTS `ims`.`items` (
	`product_id` int NOT NULL AUTO_INCREMENT,
	`product_name` char(25) NULL DEFAULT NULL,
	`product_type` char(20) NULL DEFAULT NULL,
	`product_price` float(11) NULL DEFAULT NULL,
	PRIMARY KEY (`product_id`)
);
create table IF NOT EXISTS `ims`.`orders` (
	`order_id` int NOT NULL AUTO_INCREMENT,
	`customer_id` int NOT NULL,
	PRIMARY KEY (`order_id`),
	foreign key (`customer_id`) references `ims`.`customers` (`id`)
);
create table IF NOT EXISTS `ims`.`orderitems` (
	`orderitems_id` int NOT NULL AUTO_INCREMENT,
	`order_id` INT NOT NULL,
	`product_id` INT,
	PRIMARY KEY (`orderitems_id`),
	CONSTRAINT foreign key (`order_id`) references `ims`.`orders` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT foreign key (`product_id`) references `ims`.`items` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

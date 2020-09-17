INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Jordan', 'Harrison');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Adam', 'Garfield');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Beth', 'Swinson');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Charlie', 'Charlston');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Danniel', 'Dennis');

INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('coke', 'drinks','1.99');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('pepsi', 'drinks','1.75');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('7up', 'drinks','2.00');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('fanta', 'drinks','1.50');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('dr pepper', 'drinks','2.50');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('pizza', 'food','4.00');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('curry', 'food','5.00');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('lamb', 'food','10.00');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('beef', 'food','8.00');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('porkchops', 'food','6.00');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('shoes', 'clothes','19.99');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('jeans', 'clothes','39.99');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('t-shirt', 'clothes','8.99');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('hoodie', 'clothes','14.99');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('jumper', 'clothes','12.99');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('USB stick', 'tech','14.99');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('keyboard', 'tech','20.99');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('webcam', 'tech','19.99');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('mouse', 'tech','9.99');
INSERT INTO `ims`.`items` (`product_name`, `product_type`,`product_price`) VALUES ('monitor', 'tech','49.99');

INSERT INTO `ims`.`orders`(`customer_id`) VALUES ('1');
INSERT INTO `ims`.`orders`(`customer_id`) VALUES ('1');
INSERT INTO `ims`.`orders`(`customer_id`) VALUES ('2');
INSERT INTO `ims`.`orders`(`customer_id`) VALUES ('2');


INSERT INTO `ims`.`orderitems`(`order_id`,`product_id`) VALUES ('1','6');
INSERT INTO `ims`.`orderitems`(`order_id`,`product_id`) VALUES ('2','5');
INSERT INTO `ims`.`orderitems`(`order_id`,`product_id`) VALUES ('3','3');
INSERT INTO `ims`.`orderitems`(`order_id`,`product_id`) VALUES ('4','11');
INSERT INTO `ims`.`orderitems`(`order_id`,`product_id`) VALUES ('5','12');


//Adatbázis létrehozása

CREATE DATABASE product;

//Product tábla létrehozása

CREATE TABLE `product`.`product` ( `product_Name` VARCHAR(250) NOT NULL , 
`product_Description` VARCHAR(250) NOT NULL , 
`product_Count` INT(11) NOT NULL , 
`product_Price` DOUBLE NOT NULL , 
`product_is_Available` TINYINT(4) NOT NULL ,
 `productID` INT(16) NOT NULL AUTO_INCREMENT , 
PRIMARY KEY (`productID`)) ENGINE = MyISAM;


//Adatok a product táblához

INSERT INTO `product` (`product_Name`, `product_Description`, `product_Count`, `product_Price`, `product_is_Available`, `productID`) VALUES 
('Huawei P Smart 2019 ', 'Kártyafüggetlen, Dual SIM, 64GB, LTE, Auróra kék', '30', '57990', '0', NULL);
INSERT INTO `product` (`product_Name`, `product_Description`, `product_Count`, `product_Price`, `product_is_Available`, `productID`) VALUES 
('Honor FlyPods Lite ', 'vezeték nélküli fülhallgató', '5', '19990', '1', NULL);
INSERT INTO `product` (`product_Name`, `product_Description`, `product_Count`, `product_Price`, `product_is_Available`, `productID`) VALUES 
('Lenovo Laptop', 'Lenovo ideapad 330 extended edition', '30','240000','1',NULL);

//User tábla létrehozása

CREATE TABLE `product`.`user` ( `id` INT(16)  NOT NULL AUTO_INCREMENT , 
`first_name` VARCHAR(255) NOT NULL , 
`last_name` VARCHAR(255) NOT NULL , 
`password` VARCHAR(255) NOT NULL , 
`user_role` INT(11) NOT NULL , 
PRIMARY KEY (`id`)) ENGINE = MyISAM;
	
//Adatok a user táblához
INSERT INTO `user` (`id`, `first_name`, `last_name`, `password`, `user_role`) VALUES (NULL, 'Teszt', 'Elek', '12345', '1');

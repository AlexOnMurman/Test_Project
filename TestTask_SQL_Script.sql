USE `Test`;

DROP TABLE IF EXISTS `User`;

CREATE TABLE `Test`.`User`(`id` INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY, `name` VARCHAR(25) NOT NULL, `age` INT NOT NULL, `isAdmin` BIT DEFAULT 0 NOT NULL, `createdDate` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert into `Test`.`user`(`name`, `age`, `isAdmin`) values ('Иванов', 23, 1);
insert into `Test`.`user`(`name`, `age`, `isAdmin`) values ('Петров', 14, 0);
insert into `Test`.`user`(`name`, `age`, `isAdmin`) values ('Сидоров', 15, 0);
insert into `Test`.`user`(`name`, `age`, `isAdmin`) values ('Смирнов', 18, 0);
insert into `Test`.`user`(`name`, `age`, `isAdmin`) values ('Гатальский', 19, 0);
insert into `Test`.`user`(`name`, `age`, `isAdmin`) values ('Азимов', 17, 0);
insert into `Test`.`user`(`name`, `age`, `isAdmin`) values ('Прохоренко', 25, 1);
insert into `Test`.`user`(`name`, `age`, `isAdmin`) values ('Иваницкий', 18, 0);

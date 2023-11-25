create schema testdb;

CREATE TABLE `testdb`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `testdb`.`booking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name`  VARCHAR(45) NULL,
  `field_one` VARCHAR(45) NULL,
  `field_two` VARCHAR(45) NULL,
  `field_three` VARCHAR(45) NULL,
  `field_four` VARCHAR(45) NULL,
  `field_five` VARCHAR(45) NULL,
  `create_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));

CREATE TABLE testdb.station (
   `id` INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  status VARCHAR(45) NULL,
  time VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


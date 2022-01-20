-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bms
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bms
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bms` DEFAULT CHARACTER SET utf8 ;
USE `bms` ;

-- -----------------------------------------------------
-- Table `bms`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bms`.`customers` (
  `id` INT NOT NULL,
  `fname` VARCHAR(45) NULL,
  `lname` VARCHAR(45) NULL,
  `phone_no` INT NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bms`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bms`.`address` (
  `id` INT NOT NULL,
  `door_no` INT NULL,
  `street_name` VARCHAR(45) NULL,
  `place` VARCHAR(45) NULL,
  `district` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `pincode` INT NULL,
  `cust_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_customers_idx` (`cust_id` ASC) VISIBLE,
  CONSTRAINT `fk_address_customers`
    FOREIGN KEY (`cust_id`)
    REFERENCES `bms`.`customers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bms`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bms`.`products` (
  `id` INT NOT NULL,
  `pname` VARCHAR(45) NULL,
  `cust_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_products_customers1_idx` (`cust_id` ASC) VISIBLE,
  CONSTRAINT `fk_products_customers1`
    FOREIGN KEY (`cust_id`)
    REFERENCES `bms`.`customers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bms`.`bms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bms`.`bms` (
  `id` INT NOT NULL,
  `quantity` INT NULL,
  `unit_price` DECIMAL NULL,
  `customer_amt` DECIMAL NULL,
  `total_amt` DECIMAL NULL,
  `balance_amt` DECIMAL NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bms`.`customers_has_bms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bms`.`customers_has_bms` (
  `customers_id` INT NOT NULL,
  `bms_id` INT NOT NULL,
  PRIMARY KEY (`customers_id`, `bms_id`),
  INDEX `fk_customers_has_bms_bms1_idx` (`bms_id` ASC) VISIBLE,
  INDEX `fk_customers_has_bms_customers1_idx` (`customers_id` ASC) VISIBLE,
  CONSTRAINT `fk_customers_has_bms_customers1`
    FOREIGN KEY (`customers_id`)
    REFERENCES `bms`.`customers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customers_has_bms_bms1`
    FOREIGN KEY (`bms_id`)
    REFERENCES `bms`.`bms` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bms`.`products_has_bms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bms`.`products_has_bms` (
  `products_id` INT NOT NULL,
  `bms_id` INT NOT NULL,
  PRIMARY KEY (`products_id`, `bms_id`),
  INDEX `fk_products_has_bms_bms1_idx` (`bms_id` ASC) VISIBLE,
  INDEX `fk_products_has_bms_products1_idx` (`products_id` ASC) VISIBLE,
  CONSTRAINT `fk_products_has_bms_products1`
    FOREIGN KEY (`products_id`)
    REFERENCES `bms`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_has_bms_bms1`
    FOREIGN KEY (`bms_id`)
    REFERENCES `bms`.`bms` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

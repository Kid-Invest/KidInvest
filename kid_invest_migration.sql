-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema kid_invest_db
-- -----------------------------------------------------
-- Capstone Project

-- -----------------------------------------------------
-- Schema kid_invest_db
--
-- Capstone Project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kid_invest_db` DEFAULT CHARACTER SET utf8 ;
USE `kid_invest_db` ;

-- -----------------------------------------------------
-- Table `kid_invest_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `balance` FLOAT NULL,
  `viewed_pages` TINYINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`stock` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `market_price` FLOAT UNSIGNED NOT NULL,
  `open_price` FLOAT UNSIGNED NOT NULL,
  `low_price` FLOAT UNSIGNED NOT NULL,
  `high_price` FLOAT UNSIGNED NOT NULL,
  `time` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`stock_transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`stock_transactions` (
  `users_id` INT UNSIGNED NOT NULL,
  `stock_id` INT UNSIGNED NOT NULL,
  `shares_bought_sold` INT NULL,
  `price` FLOAT NULL,
  `time` DATETIME NULL,
  PRIMARY KEY (`users_id`, `stock_id`),
  INDEX `fk_users_stock_stock1_idx` (`stock_id` ASC),
  INDEX `fk_users_stock_users_idx` (`users_id` ASC),
  CONSTRAINT `fk_users_stock_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `kid_invest_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_stock_stock1`
    FOREIGN KEY (`stock_id`)
    REFERENCES `kid_invest_db`.`stock` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`business`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`business` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `popularity` INT NOT NULL,
  `users_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_business_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_business_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `kid_invest_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`lemonades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`lemonades` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `price` FLOAT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`ingredients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`ingredients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `cost` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`business_has_ingredient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`business_has_ingredient` (
  `business_id` INT UNSIGNED NOT NULL,
  `ingredient_id` INT NOT NULL,
  `purchased_ingredients` INT NULL,
  `time` DATETIME NULL,
  PRIMARY KEY (`business_id`, `ingredient_id`),
  INDEX `fk_business_has_ingredient_ingredient1_idx` (`ingredient_id` ASC),
  INDEX `fk_business_has_ingredient_business1_idx` (`business_id` ASC),
  CONSTRAINT `fk_business_has_ingredient_business1`
    FOREIGN KEY (`business_id`)
    REFERENCES `kid_invest_db`.`business` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_business_has_ingredient_ingredient1`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `kid_invest_db`.`ingredients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`sales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`sales` (
  `curr_date` DATE NOT NULL,
  `profit` FLOAT NULL,
  `business_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`business_id`, `curr_date`),
  INDEX `fk_sales_business1_idx` (`business_id` ASC),
  CONSTRAINT `fk_sales_business1`
    FOREIGN KEY (`business_id`)
    REFERENCES `kid_invest_db`.`business` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`addons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`addons` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `pop_bonus` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`lemonades_has_ingredients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`lemonades_has_ingredients` (
  `lemonades_id` INT NOT NULL,
  `ingredients_id` INT NOT NULL,
  `count` INT NULL,
  PRIMARY KEY (`lemonades_id`, `ingredients_id`),
  INDEX `fk_lemonades_has_ingredients_ingredients1_idx` (`ingredients_id` ASC),
  INDEX `fk_lemonades_has_ingredients_lemonades1_idx` (`lemonades_id` ASC),
  CONSTRAINT `fk_lemonades_has_ingredients_lemonades1`
    FOREIGN KEY (`lemonades_id`)
    REFERENCES `kid_invest_db`.`lemonades` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lemonades_has_ingredients_ingredients1`
    FOREIGN KEY (`ingredients_id`)
    REFERENCES `kid_invest_db`.`ingredients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`users_has_stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`users_has_stock` (
  `users_id` INT UNSIGNED NOT NULL,
  `stock_id` INT UNSIGNED NOT NULL,
  `shares` INT NULL,
  PRIMARY KEY (`users_id`, `stock_id`),
  INDEX `fk_users_has_stock_stock1_idx` (`stock_id` ASC),
  INDEX `fk_users_has_stock_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_users_has_stock_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `kid_invest_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_stock_stock1`
    FOREIGN KEY (`stock_id`)
    REFERENCES `kid_invest_db`.`stock` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`business_has_addons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`business_has_addons` (
  `business_id` INT UNSIGNED NOT NULL,
  `addons_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`business_id`, `addons_id`),
  INDEX `fk_business_has_addons_addons1_idx` (`addons_id` ASC),
  INDEX `fk_business_has_addons_business1_idx` (`business_id` ASC),
  CONSTRAINT `fk_business_has_addons_business1`
    FOREIGN KEY (`business_id`)
    REFERENCES `kid_invest_db`.`business` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_business_has_addons_addons1`
    FOREIGN KEY (`addons_id`)
    REFERENCES `kid_invest_db`.`addons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

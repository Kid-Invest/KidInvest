-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema kid_invest_test_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema kid_invest_test_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kid_invest_test_db` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema kid_invest_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema kid_invest_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kid_invest_db` DEFAULT CHARACTER SET utf8 ;
USE `kid_invest_test_db` ;

-- -----------------------------------------------------
-- Table `kid_invest_test_db`.`addons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_test_db`.`addons` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `popularity_bonus` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_j219ibnsbmrxf4ws51h9qne3h` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_test_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_test_db`.`users` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `balance` DOUBLE NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `viewed_portfolio` BIT(1) NULL DEFAULT NULL,
  `viewed_stand` BIT(1) NULL DEFAULT NULL,
  `viewed_stocks` BIT(1) NULL DEFAULT NULL,
  `viewed_store` BIT(1) NULL DEFAULT NULL,
  `viewed_transactions` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_6dotkott2kjsp8vw4d0m25fb7` (`email` ASC),
  UNIQUE INDEX `UK_r43af9ap4edm43mmtq01oddj6` (`username` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_test_db`.`business`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_test_db`.`business` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `popularity` INT(11) NOT NULL,
  `user_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKtm7f6x8bo3o8pk2kraawyq18u` (`user_id` ASC),
  CONSTRAINT `FKtm7f6x8bo3o8pk2kraawyq18u`
    FOREIGN KEY (`user_id`)
    REFERENCES `kid_invest_test_db`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_test_db`.`business_has_addons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_test_db`.`business_has_addons` (
  `business_id` BIGINT(20) NOT NULL,
  `addon_id` BIGINT(20) NOT NULL,
  INDEX `FKh748xqn1ebt9f8h3yq5xmm9k6` (`addon_id` ASC),
  INDEX `FK1yncdp8fvngun2va96sj354dr` (`business_id` ASC),
  CONSTRAINT `FK1yncdp8fvngun2va96sj354dr`
    FOREIGN KEY (`business_id`)
    REFERENCES `kid_invest_test_db`.`business` (`id`),
  CONSTRAINT `FKh748xqn1ebt9f8h3yq5xmm9k6`
    FOREIGN KEY (`addon_id`)
    REFERENCES `kid_invest_test_db`.`addons` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_test_db`.`ingredients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_test_db`.`ingredients` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cost` DOUBLE NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_j6tsl15xx76y4kv41yxr4uxab` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_test_db`.`business_transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_test_db`.`business_transactions` (
  `purchase_count` BIGINT(20) NULL DEFAULT NULL,
  `time` DATETIME(6) NULL DEFAULT NULL,
  `ingredient_id` BIGINT(20) NOT NULL,
  `business_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`ingredient_id`, `business_id`),
  INDEX `FKru3g9bux4cyxk86cg7s3qargp` (`business_id` ASC),
  CONSTRAINT `FKeca1r50hxjg0r32sey4ougqmt`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `kid_invest_test_db`.`ingredients` (`id`),
  CONSTRAINT `FKru3g9bux4cyxk86cg7s3qargp`
    FOREIGN KEY (`business_id`)
    REFERENCES `kid_invest_test_db`.`business` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_test_db`.`inventory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_test_db`.`inventory` (
  `total` BIGINT(20) NOT NULL,
  `ingredient_id` BIGINT(20) NOT NULL,
  `business_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`ingredient_id`, `business_id`),
  INDEX `FKob4pbo8j5tpdhxnfcuaktw0ux` (`business_id` ASC),
  CONSTRAINT `FKgmm3s8uda69rrf2cuqea6x55y`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `kid_invest_test_db`.`ingredients` (`id`),
  CONSTRAINT `FKob4pbo8j5tpdhxnfcuaktw0ux`
    FOREIGN KEY (`business_id`)
    REFERENCES `kid_invest_test_db`.`business` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_test_db`.`lemonades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_test_db`.`lemonades` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_fcqvk6e8ethe7f1gp632f1c44` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_test_db`.`lemonades_has_ingredients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_test_db`.`lemonades_has_ingredients` (
  `count` BIGINT(20) NULL DEFAULT NULL,
  `lemonade_id` BIGINT(20) NOT NULL,
  `ingredient_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`lemonade_id`, `ingredient_id`),
  INDEX `FKdpwj6jqrwksgovibmygltb7e` (`ingredient_id` ASC),
  CONSTRAINT `FKdpwj6jqrwksgovibmygltb7e`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `kid_invest_test_db`.`ingredients` (`id`),
  CONSTRAINT `FKk59k08kmo28wj6oiwjfx0gar0`
    FOREIGN KEY (`lemonade_id`)
    REFERENCES `kid_invest_test_db`.`lemonades` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_test_db`.`sales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_test_db`.`sales` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `profit` DOUBLE NOT NULL,
  `sale_date` DATE NULL DEFAULT NULL,
  `business_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKqphdxw2uf2ebneuwme52q9ba` (`business_id` ASC),
  CONSTRAINT `FKqphdxw2uf2ebneuwme52q9ba`
    FOREIGN KEY (`business_id`)
    REFERENCES `kid_invest_test_db`.`business` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_test_db`.`stocks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_test_db`.`stocks` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `high_price` DOUBLE NOT NULL,
  `low_price` DOUBLE NOT NULL,
  `market_price` DOUBLE NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `open_price` DOUBLE NOT NULL,
  `time` DATETIME(6) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_test_db`.`stock_transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_test_db`.`stock_transactions` (
  `price` DOUBLE NULL DEFAULT NULL,
  `shares_bought_sold` BIGINT(20) NULL DEFAULT NULL,
  `time` DATETIME(6) NULL DEFAULT NULL,
  `user_id` BIGINT(20) NOT NULL,
  `stock_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`user_id`, `stock_id`),
  INDEX `FK9o1h44dum5w6crptyenspa446` (`stock_id` ASC),
  CONSTRAINT `FK22636p8lnuf1dl7tvet5dnjfs`
    FOREIGN KEY (`user_id`)
    REFERENCES `kid_invest_test_db`.`users` (`id`),
  CONSTRAINT `FK9o1h44dum5w6crptyenspa446`
    FOREIGN KEY (`stock_id`)
    REFERENCES `kid_invest_test_db`.`stocks` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_test_db`.`user_has_stocks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_test_db`.`user_has_stocks` (
  `shares` BIGINT(20) NULL DEFAULT NULL,
  `user_id` BIGINT(20) NOT NULL,
  `stock_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`user_id`, `stock_id`),
  INDEX `FKtoq2sbywfgv8jhkitjd9mmtlt` (`stock_id` ASC),
  CONSTRAINT `FK8v06n0kwmk6nbo7w1aksycmbc`
    FOREIGN KEY (`user_id`)
    REFERENCES `kid_invest_test_db`.`users` (`id`),
  CONSTRAINT `FKtoq2sbywfgv8jhkitjd9mmtlt`
    FOREIGN KEY (`stock_id`)
    REFERENCES `kid_invest_test_db`.`stocks` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `kid_invest_db` ;

-- -----------------------------------------------------
-- Table `kid_invest_db`.`addons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`addons` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `popularity_bonus` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_j219ibnsbmrxf4ws51h9qne3h` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`users` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `balance` DOUBLE NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `viewed_portfolio` BIT(1) NULL DEFAULT NULL,
  `viewed_stand` BIT(1) NULL DEFAULT NULL,
  `viewed_stocks` BIT(1) NULL DEFAULT NULL,
  `viewed_store` BIT(1) NULL DEFAULT NULL,
  `viewed_transactions` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_6dotkott2kjsp8vw4d0m25fb7` (`email` ASC),
  UNIQUE INDEX `UK_r43af9ap4edm43mmtq01oddj6` (`username` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`business`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`business` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `popularity` INT(11) NOT NULL,
  `user_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKtm7f6x8bo3o8pk2kraawyq18u` (`user_id` ASC),
  CONSTRAINT `FKtm7f6x8bo3o8pk2kraawyq18u`
    FOREIGN KEY (`user_id`)
    REFERENCES `kid_invest_db`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`business_has_addons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`business_has_addons` (
  `business_id` BIGINT(20) NOT NULL,
  `addon_id` BIGINT(20) NOT NULL,
  INDEX `FKh748xqn1ebt9f8h3yq5xmm9k6` (`addon_id` ASC),
  INDEX `FK1yncdp8fvngun2va96sj354dr` (`business_id` ASC),
  CONSTRAINT `FK1yncdp8fvngun2va96sj354dr`
    FOREIGN KEY (`business_id`)
    REFERENCES `kid_invest_db`.`business` (`id`),
  CONSTRAINT `FKh748xqn1ebt9f8h3yq5xmm9k6`
    FOREIGN KEY (`addon_id`)
    REFERENCES `kid_invest_db`.`addons` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`ingredients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`ingredients` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cost` DOUBLE NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_j6tsl15xx76y4kv41yxr4uxab` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`business_transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`business_transactions` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `purchase_count` BIGINT(20) NULL DEFAULT NULL,
  `time` DATETIME(6) NULL DEFAULT NULL,
  `business_id` BIGINT(20) NULL DEFAULT NULL,
  `ingredient_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKru3g9bux4cyxk86cg7s3qargp` (`business_id` ASC),
  INDEX `FKeca1r50hxjg0r32sey4ougqmt` (`ingredient_id` ASC),
  CONSTRAINT `FKeca1r50hxjg0r32sey4ougqmt`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `kid_invest_db`.`ingredients` (`id`),
  CONSTRAINT `FKru3g9bux4cyxk86cg7s3qargp`
    FOREIGN KEY (`business_id`)
    REFERENCES `kid_invest_db`.`business` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 37
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`inventory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`inventory` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `total` BIGINT(20) NOT NULL,
  `business_id` BIGINT(20) NULL DEFAULT NULL,
  `ingredient_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKob4pbo8j5tpdhxnfcuaktw0ux` (`business_id` ASC),
  INDEX `FKgmm3s8uda69rrf2cuqea6x55y` (`ingredient_id` ASC),
  CONSTRAINT `FKgmm3s8uda69rrf2cuqea6x55y`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `kid_invest_db`.`ingredients` (`id`),
  CONSTRAINT `FKob4pbo8j5tpdhxnfcuaktw0ux`
    FOREIGN KEY (`business_id`)
    REFERENCES `kid_invest_db`.`business` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 37
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`lemonades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`lemonades` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_fcqvk6e8ethe7f1gp632f1c44` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`lemonades_has_ingredients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`lemonades_has_ingredients` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `count` BIGINT(20) NULL DEFAULT NULL,
  `ingredient_id` BIGINT(20) NULL DEFAULT NULL,
  `lemonade_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKdpwj6jqrwksgovibmygltb7e` (`ingredient_id` ASC),
  INDEX `FKk59k08kmo28wj6oiwjfx0gar0` (`lemonade_id` ASC),
  CONSTRAINT `FKdpwj6jqrwksgovibmygltb7e`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `kid_invest_db`.`ingredients` (`id`),
  CONSTRAINT `FKk59k08kmo28wj6oiwjfx0gar0`
    FOREIGN KEY (`lemonade_id`)
    REFERENCES `kid_invest_db`.`lemonades` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`sales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`sales` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `profit` DOUBLE NOT NULL,
  `sale_date` DATE NULL DEFAULT NULL,
  `business_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKqphdxw2uf2ebneuwme52q9ba` (`business_id` ASC),
  CONSTRAINT `FKqphdxw2uf2ebneuwme52q9ba`
    FOREIGN KEY (`business_id`)
    REFERENCES `kid_invest_db`.`business` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`stocks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`stocks` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `high_price` DOUBLE NOT NULL,
  `low_price` DOUBLE NOT NULL,
  `market_price` DOUBLE NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `open_price` DOUBLE NOT NULL,
  `time` DATETIME(6) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`stock_transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`stock_transactions` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `price` DOUBLE NULL DEFAULT NULL,
  `shares_bought_sold` BIGINT(20) NULL DEFAULT NULL,
  `time` DATETIME(6) NULL DEFAULT NULL,
  `stock_id` BIGINT(20) NULL DEFAULT NULL,
  `user_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK9o1h44dum5w6crptyenspa446` (`stock_id` ASC),
  INDEX `FK22636p8lnuf1dl7tvet5dnjfs` (`user_id` ASC),
  CONSTRAINT `FK22636p8lnuf1dl7tvet5dnjfs`
    FOREIGN KEY (`user_id`)
    REFERENCES `kid_invest_db`.`users` (`id`),
  CONSTRAINT `FK9o1h44dum5w6crptyenspa446`
    FOREIGN KEY (`stock_id`)
    REFERENCES `kid_invest_db`.`stocks` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kid_invest_db`.`user_has_stocks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kid_invest_db`.`user_has_stocks` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `shares` BIGINT(20) NULL DEFAULT NULL,
  `stock_id` BIGINT(20) NULL DEFAULT NULL,
  `user_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKtoq2sbywfgv8jhkitjd9mmtlt` (`stock_id` ASC),
  INDEX `FK8v06n0kwmk6nbo7w1aksycmbc` (`user_id` ASC),
  CONSTRAINT `FK8v06n0kwmk6nbo7w1aksycmbc`
    FOREIGN KEY (`user_id`)
    REFERENCES `kid_invest_db`.`users` (`id`),
  CONSTRAINT `FKtoq2sbywfgv8jhkitjd9mmtlt`
    FOREIGN KEY (`stock_id`)
    REFERENCES `kid_invest_db`.`stocks` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

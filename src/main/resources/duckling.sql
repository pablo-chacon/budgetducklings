CREATE SCHEMA IF NOT EXISTS `duckling` DEFAULT CHARACTER SET utf8 ;
USE `duckling` ;

-- -----------------------------------------------------
-- Table `duckling`.`employee_tbl`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS ducklings_tbl (
    `ducklingID` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) DEFAULT NULL,
    `email` VARCHAR(45) NOT NULL,
    PRIMARY KEY (username),
    INDEX (username),
    FOREIGN KEY (`username`)
    REFERENCES receipt_tbl (`receiptID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `duckling`.`receipt_tbl`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS receipt_tbl (
    `receiptID` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(25) NULL,
    `date` DATE NOT NULL,
    `category` VARCHAR(15) NULL,
    `price` VARCHAR(8) NOT NULL,
    `description` VARCHAR(255) NULL,
    PRIMARY KEY (`date`),
    FOREIGN KEY (`receiptID`)
    REFERENCES ducklings_tbl (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

USE `duckling` ;


START TRANSACTION;
USE `duckling`;
INSERT INTO `ducklings_tbl` (`ducklingID`, username, `password`, `email`) VALUES (1, 'Scrooge', 'foo123', 'scrooge@duckling.duck');
INSERT INTO `ducklings_tbl` (`ducklingID`, username, `password`, `email`) VALUES (2, 'Huey', 'bar123', 'huey@duckling.duck');
INSERT INTO `ducklings_tbl` (`ducklingID`, username, `password`, `email`) VALUES (3, 'Dewey', 'foobar', 'dewey@duckling.duck');
INSERT INTO `ducklings_tbl` (`ducklingID`, username, `password`, `email`) VALUES (4, 'Louie', 'barfoo', 'louie@duckling.duck');

COMMIT;


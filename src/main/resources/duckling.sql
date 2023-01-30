CREATE SCHEMA IF NOT EXISTS `duckling` DEFAULT CHARACTER SET utf8 ;
USE `duckling` ;

-- -----------------------------------------------------
-- Table `duckling`.`employee_tbl`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `duckling`.`ducklings_tbl` (
    `ducklingID` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
    `password` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`ducklingid`),
    CONSTRAINT `fk_duckling_1`
    FOREIGN KEY (`ducklingID`)
    REFERENCES `duckling`.`receipt_tbl` (`receiptID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `duckling`.`receipt_tbl`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `duckling`.`receipt_tbl` (
    `receiptID` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(25) NULL,
    `date` DATE NOT NULL,
    `category` VARCHAR(15) NULL,
    `price` VARCHAR(8) NOT NULL,
    `description` VARCHAR(255) NULL,
    PRIMARY KEY (`receiptID`),
    CONSTRAINT `fk_receipt`
    FOREIGN KEY (`receiptID`)
    REFERENCES `mydb`.`employee_tbl` (`´ducklingID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

USE `duckling` ;

-- -----------------------------------------------------
-- Placeholder table for view `duckling`.`view_receipts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `duckling`.`view_receipts` (`'Col_placeholder1'` INT);


DROP VIEW IF EXISTS `duckling`.`view_receipts` ;
USE `duckling`;
CREATE OR REPLACE VIEW view_receipts AS
SELECT (ducklings_tbl.ducklingID) AS 'Col_placeholder1'
FROM
    (SELECT *
     FROM receipt_tbl) receipts
        INNER JOIN
    (SELECT ducklingID
     FROM receipt_tbl WHERE employeeid(name)) name;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- Duckling data.

START TRANSACTION;
USE `duckling`;
INSERT INTO `duckling`.`ducklings_tbl` (`ducklingID`, `name`, `email`) VALUES (DEFAULT, 'Scrooge', 'foo123', 'scrooge@duckling.duck');
INSERT INTO `duckling`.`ducklings_tbl` (`ducklingID`, `name`, `email`) VALUES (DEFAULT, 'Huey', 'bar123', 'huey@duckling.duck');
INSERT INTO `duckling`.`ducklings_tbl` (`ducklingID`, `name`, `email`) VALUES (DEFAULT, 'Dewey', 'foobar', 'dewey@duckling.duck');
INSERT INTO `duckling`.`ducklings_tbl` (`ducklingID`, `name`, `email`) VALUES (DEFAULT, 'Louie', 'barfoo', 'louie@duckling.duck');

COMMIT;


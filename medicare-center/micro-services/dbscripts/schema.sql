SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema medicare
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema medicare
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `medicare` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `medicare` ;

-- -----------------------------------------------------
-- Table `medicare`.`admin_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`admin_table` (
  `ad_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ad_age` INT(11) NULL DEFAULT NULL,
  `ad_alt_contact` BIGINT(20) NULL DEFAULT NULL,
  `ad_contact` BIGINT(20) NULL DEFAULT NULL,
  `ad_dob` DATETIME NULL DEFAULT NULL,
  `ad_email` VARCHAR(255) NULL DEFAULT NULL,
  `ad_first_name` VARCHAR(255) NULL DEFAULT NULL,
  `ad_gender` VARCHAR(255) NULL DEFAULT NULL,
  `ad_last_name` VARCHAR(255) NULL DEFAULT NULL,
  `ad_password` VARCHAR(255) NULL DEFAULT NULL,
  `ad_user_name` VARCHAR(255) NULL DEFAULT NULL,
  `us_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ad_id`),
  INDEX `FKhpc86dv3amgx798p0i2hd4mjt` (`us_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medicare`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`doctor` (
  `do_id` INT(11) NOT NULL AUTO_INCREMENT,
  `do_address_line_1` VARCHAR(255) NULL DEFAULT NULL,
  `do_address_line_2` VARCHAR(255) NULL DEFAULT NULL,
  `do_age` INT(11) NULL DEFAULT NULL,
  `do_alt_contact_number` BIGINT(20) NULL DEFAULT NULL,
  `do_city` VARCHAR(255) NULL DEFAULT NULL,
  `do_contact_number` BIGINT(20) NULL DEFAULT NULL,
  `do_date_of_birth` DATETIME NULL DEFAULT NULL,
  `do_degree` VARCHAR(255) NULL DEFAULT NULL,
  `do_email_id` VARCHAR(255) NULL DEFAULT NULL,
  `do_first_name` VARCHAR(255) NULL DEFAULT NULL,
  `do_gender` VARCHAR(255) NULL DEFAULT NULL,
  `do_hospital_name` VARCHAR(255) NULL DEFAULT NULL,
  `do_last_name` VARCHAR(255) NULL DEFAULT NULL,
  `do_password` VARCHAR(255) NULL DEFAULT NULL,
  `do_speciality` VARCHAR(255) NULL DEFAULT NULL,
  `do_state` VARCHAR(255) NULL DEFAULT NULL,
  `do_user_name` VARCHAR(255) NULL DEFAULT NULL,
  `do_work_hours` VARCHAR(255) NULL DEFAULT NULL,
  `do_zip_code` BIGINT(20) NULL DEFAULT NULL,
  `us_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`do_id`),
  INDEX `FKsu6yjihwq960qing8wqn1ff5` (`us_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medicare`.`doctor_medicare_services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`doctor_medicare_services` (
  `dm_do_id` INT(11) NOT NULL,
  `dm_ms_id` INT(11) NOT NULL,
  PRIMARY KEY (`dm_do_id`, `dm_ms_id`),
  INDEX `FKgprqjin3svp55x8mb7gwsjh3y` (`dm_ms_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medicare`.`medicare_services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`medicare_services` (
  `ms_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ms_amount` BIGINT(20) NULL DEFAULT NULL,
  `ms_medicare_service` VARCHAR(255) NULL DEFAULT NULL,
  `ms_service_description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ms_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medicare`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`patient` (
  `pa_id` INT(11) NOT NULL AUTO_INCREMENT,
  `pa_address_line_1` VARCHAR(255) NULL DEFAULT NULL,
  `pa_address_line_2` VARCHAR(255) NULL DEFAULT NULL,
  `pa_age` INT(11) NULL DEFAULT NULL,
  `pa_alt_contact` BIGINT(20) NULL DEFAULT NULL,
  `pa_city` VARCHAR(255) NULL DEFAULT NULL,
  `pa_contact` BIGINT(20) NULL DEFAULT NULL,
  `pa_dob` DATETIME NULL DEFAULT NULL,
  `pa_email` VARCHAR(255) NULL DEFAULT NULL,
  `pa_first_name` VARCHAR(255) NULL DEFAULT NULL,
  `pa_gender` VARCHAR(255) NULL DEFAULT NULL,
  `pa_last_name` VARCHAR(255) NULL DEFAULT NULL,
  `pa_password` VARCHAR(255) NULL DEFAULT NULL,
  `pa_state` VARCHAR(255) NULL DEFAULT NULL,
  `pa_user_name` VARCHAR(255) NULL DEFAULT NULL,
  `pa_zip_code` BIGINT(20) NULL DEFAULT NULL,
  `us_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`pa_id`),
  INDEX `FK4hhe7ag9t12hnec2drqcuce4y` (`us_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medicare`.`request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`request` (
  `re_id` INT(11) NOT NULL AUTO_INCREMENT,
  `re_approve` VARCHAR(255) NULL DEFAULT NULL,
  `re_date` DATETIME NULL DEFAULT NULL,
  `do_id` INT(11) NULL DEFAULT NULL,
  `ms_id` INT(11) NULL DEFAULT NULL,
  `pa_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`re_id`),
  INDEX `FK31ob4uxqd69psabammmroxbha` (`do_id` ASC),
  INDEX `FKh44ug4lrsb2qlyhnsfjcgu02c` (`ms_id` ASC),
  INDEX `FKcp4kxkba7myo4x7khdjj982o3` (`pa_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medicare`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`role` (
  `ro_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ro_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `medicare`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_approve` VARCHAR(255) NOT NULL,
  `us_password` VARCHAR(255) NOT NULL,
  `us_name` VARCHAR(10) NOT NULL,
  `ro_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`),
  INDEX `FKswoqccda8ufyk6j4uvkwc98ss` (`ro_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `medicare`.`role`
(`ro_name`)
VALUES
('ROLE_ADMIN'),('ROLE_PATIENT'),('ROLE_DOCTOR');

INSERT INTO `medicare`.`medicare_services`
(`ms_id`,
`ms_medicare_service`,
`ms_service_description`,
`ms_amount`)
VALUES
(1,
'MRI Scan',
'Brain working frequency check',
2000);
INSERT INTO `medicare`.`medicare_services`
(`ms_id`,
`ms_medicare_service`,
`ms_service_description`,
`ms_amount`)
VALUES
(2,
'Abdomen Scan',
'Organ Diagnosis',
3000);
INSERT INTO `medicare`.`medicare_services`
(`ms_id`,
`ms_medicare_service`,
`ms_service_description`,
`ms_amount`)
VALUES
(3,
'Cardiology',
'Heart Diagnosis',
4000); 
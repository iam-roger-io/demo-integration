
#CREATE DATABASE `demointegrationdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

use demointegrationdb;

CREATE TABLE `country` (
  `country_code` varchar(4) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`country_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `state` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country_code` varchar(4) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `abbreviation` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `people` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `social_security` varchar(14) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `address2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state_id` int DEFAULT NULL,
  `zip_code` varchar(45) DEFAULT NULL,
  `country_code` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `demointegrationdb`.`country` (country_code, name) VALUES ("BR", "Brazil");
INSERT INTO `demointegrationdb`.`country` (country_code, name) VALUES ("USA", "United States");
INSERT INTO `demointegrationdb`.`country` (country_code, name) VALUES ("MX", "Mexico");

INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Acre", "AC", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Alagoas","AL", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Amapá", "AP", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Amazonas", "AM", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Bahia", "BA", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Ceará", "CE", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Distrito Federal", "DF", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Espírito Santo", "ES", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Goiás", "GO", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Maranhão","MA", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Mato Grosso","MT", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Mato Grosso do Sul","MS", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Minas Gerais","MG", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Pará","PA", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Paraíba","PB", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Paraná","PR", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Pernambuco","PE", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Piauí","PI", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Rio de Janeiro","RJ", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Rio Grande do Norte","RN", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Rio Grande do Sul"," RS", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Rondônia","RO", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Roraima"," RR", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Santa Catarina","SC", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("São Paulo","SP", "BR");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Tocantins","TO", "BR");

#United States

INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Alaska", "AK", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Arizona", "AZ", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Arkansas", "AR", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("California", "CA", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Colorado", "CO", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Connecticut", "CT", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Delaware", "DE", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("District of Columbia", "DC", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Florida", "FL", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Georgia", "GA", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Hawaii", "HI", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Idaho", "ID", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Illinois", "IL", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Indiana", "IN", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Iowa", "IA", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Kansas", "KS", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Kentucky", "KY", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Louisiana", "LA", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Maine", "ME", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Maryland", "MD", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Massachusetts", "MA", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Michigan", "MI", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Minnesota", "MN", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Mississippi", "MS", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Missouri", "MO", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Montana", "MT", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Nebraska", "NE", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Nevada", "NV", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("New Hampshire", "NH", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("New Jersey", "NJ", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("New Mexico", "NM", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("New York", "NY", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("North Carolina", "NC", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("North Dakota", "ND", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Ohio", "OH", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Oklahoma", "OK", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Oregon", "OR", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Pennsylvania", "PA", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Rhode Island", "RI", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("South Carolina", "SC", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("South Dakota", "SD", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Tennessee", "TN", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Texas", "TX", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Utah", "UT", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Vermont", "VT", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Virginia", "VA", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Washington", "WA", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("West Virginia", "WV", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Wisconsin", "WI", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Wyoming", "WY", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("American Samoa", "AS", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Guam", "GU", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Northern Mariana Islands", "MP", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Puerto Rico", "PR", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Virgin Islands", "VI", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Armed Forces Africa", "AE", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Armed Forces Americas", "AA", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Armed Forces Canada", "AE", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Armed Forces Europe", "AE", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Armed Forces Middle East", "AE", "USA");
INSERT INTO `demointegrationdb`.`state` (`name`, `abbreviation`, `country_code`) VALUES  ("Armed Forces Pacific", "AP", "USA");
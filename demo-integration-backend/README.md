#demo-integration-backend

## DataBase

### Schema MySQL

```
CREATE DATABASE `demo-integraton-database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
```

### Tables
```
CREATE TABLE `country` (
  `id` varchar(4) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `state` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `abbreviation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `person` (
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
  `country_id` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

```  

### Data
``` 
INSERT INTO `demo-integraton-database`.`country` (id, name) VALUES ("BR", "Brazil");
INSERT INTO `demo-integraton-database`.`country` (id, name) VALUES ("USA", "United States");
INSERT INTO `demo-integraton-database`.`country` (id, name) VALUES ("MX", "Mexico");

INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (1,"Acre", "AC");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (2,"Alagoas","AL");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (3,"Amapá", "AP");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (4,"Amazonas", "AM");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (5,"Bahia", "BA");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (6,"Ceará", "CE");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (7,"Distrito Federal", "DF");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (8,"Espírito Santo", "ES");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (9,"Goiás", "GO");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (10,"Maranhão","MA");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (11,"Mato Grosso","MT");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (12,"Mato Grosso do Sul","MS");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (13,"Minas Gerais","MG");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (14,"Pará","PA");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (15,"Paraíba","PB");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (16,"Paraná","PR");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (17,"Pernambuco","PE");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (18,"Piauí","PI");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (19,"Rio de Janeiro","RJ");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (20,"Rio Grande do Norte","RN");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (21,"Rio Grande do Sul"," RS");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (22,"Rondônia","RO");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (23,"Roraima"," RR");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (24,"Santa Catarina","SC");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (25,"São Paulo","SP");
INSERT INTO `demo-integraton-database`.`state` (`id`, `name`, `abbreviation`) VALUES  (26,"Tocantins","TO");
``` 
CREATE TABLE `cities` (
  `id`              INT         NOT NULL  AUTO_INCREMENT,
  `version`         INT         NOT NULL  DEFAULT 0,
  `name`            VARCHAR(45) NOT NULL  UNIQUE ,
  `state`           VARCHAR(45) NOT NULL,
  `day_rate`        FLOAT       NOT NULL  DEFAULT 0,
  `night_rate`      FLOAT       NOT NULL  DEFAULT 0,
  `created`         TIMESTAMP   NOT NULL  DEFAULT NOW(),
  `modified`        TIMESTAMP   NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));

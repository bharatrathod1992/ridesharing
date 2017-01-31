CREATE TABLE `cars` (
  `id`        INT         NOT NULL AUTO_INCREMENT,
  `version`   INT         NOT NULL DEFAULT 0,
  `make`      VARCHAR(45) NOT NULL,
  `model`     VARCHAR(45) NOT NULL,
  `year`      INT         NOT NULL,
  `type`      ENUM('NORMAL', 'LUX') NOT NULL,
  `created`   TIMESTAMP   NOT NULL DEFAULT now(),
  `modified`  TIMESTAMP   NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`));
CREATE TABLE `passengers` (
  `id`              INT                     NOT NULL AUTO_INCREMENT,
  `version`         INT                     NOT NULL DEFAULT 0,
  `name`            VARCHAR(45)             NOT NULL,
  `age`             INT NOT NULL,
  `gender`          ENUM('MALE', 'FEMALE')  NOT NULL,
  `credit`          FLOAT                   NOT NULL,
  `created`         TIMESTAMP               NULL DEFAULT NOW(),
  `modified`        TIMESTAMP               NULL DEFAULT NOW(),
  PRIMARY KEY (`id`));

CREATE TABLE `trips` (
  `id`                    INT       NOT NULL AUTO_INCREMENT,
  `version`               INT       NOT NULL DEFAULT 0,
  `trip_type`             ENUM('DAY', 'NIGHT') NOT NULL,
  `distance_travelled`    FLOAT     NOT NULL,
  `fare`                  FLOAT     NOT NULL,
  `tip_percent`           INT       NOT NULL,
  `final_fare`            FLOAT     NOT NULL,
  `created`               TIMESTAMP NOT NULL DEFAULT now(),
  `modified`              TIMESTAMP NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`));
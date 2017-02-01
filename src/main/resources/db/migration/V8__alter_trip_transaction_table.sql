ALTER TABLE `trips` ADD COLUMN `cars_id` INT NOT NULL ;
ALTER TABLE `trips` ADD COLUMN `passengers_id` INT NOT NULL ;
ALTER TABLE `trips` ADD COLUMN `drivers_id` INT NOT NULL ;
ALTER TABLE `trips` ADD CONSTRAINT `fk_cars_id` FOREIGN KEY (cars_id) REFERENCES cars(id);
ALTER TABLE `trips` ADD CONSTRAINT `fk_passengers_id` FOREIGN KEY (passengers_id) REFERENCES passengers(id);
ALTER TABLE `trips` ADD CONSTRAINT `fk1_drivers_id` FOREIGN KEY (drivers_id) REFERENCES drivers(id);
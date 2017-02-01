ALTER TABLE cars ADD COLUMN drivers_id INT NOT NULL;
ALTER TABLE cars ADD COLUMN cities_id INT NOT NULL;
ALTER TABLE cars ADD CONSTRAINT `fk_drivers_id` FOREIGN KEY(drivers_id) REFERENCES drivers(id);
ALTER TABLE cars ADD CONSTRAINT `fk_cities_id` FOREIGN KEY(cities_id) REFERENCES cities(id);
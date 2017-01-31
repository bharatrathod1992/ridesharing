ALTER TABLE cars ADD COLUMN drivers_id INT NOT NULL;
ALTER TABLE cars ADD CONSTRAINT `fk_drivers_id` FOREIGN KEY(drivers_id) REFERENCES drivers(id);
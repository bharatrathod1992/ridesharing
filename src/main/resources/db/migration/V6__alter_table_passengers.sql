ALTER TABLE passengers ADD COLUMN cities_id INT NOT NULL;
ALTER TABLE passengers ADD CONSTRAINT `fk_cities_id` FOREIGN KEY (`cities_id`) REFERENCES cities(id);
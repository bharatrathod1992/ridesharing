use ridesharingtest;

TRUNCATE TABLE cities;
TRUNCATE TABLE cars;

INSERT INTO cities (`name`,`state`,`day_rate`,`night_rate`)
            values('Banglore','Karnataka',50,75),
                  ('Pune','Maharashtra',50,70);

INSERT INTO cities (`make`,`model`,`year`,`type`)
values('TOYOTA','INNOVA',2012,'LUX');

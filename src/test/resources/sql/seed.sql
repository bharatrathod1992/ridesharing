use ridesharingtest;

TRUNCATE TABLE cities;
TRUNCATE TABLE cars;
TRUNCATE TABLE drivers;
TRUNCATE TABLE passengers;

INSERT INTO cities (`name`,`state`,`day_rate`,`night_rate`)
            values('Banglore','Karnataka',50,75),
                  ('Pune','Maharashtra',50,70);

INSERT INTO cars (`make`,`model`,`year`,`type`)
            values('TOYOTA','INNOVA',2012,'LUX');

INSERT INTO drivers (`name`,`age`,`gender`)
            values('Bharat',25,'MALE');

INSERT INTO passengers (`name`,`age`,`gender`,`credit`)
            values('Sumit',25,'MALE',100);
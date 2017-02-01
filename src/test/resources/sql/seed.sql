use ridesharingtest;

set FOREIGN_KEY_CHECKS =0;
TRUNCATE TABLE cities;
TRUNCATE TABLE drivers;
TRUNCATE TABLE cars;
TRUNCATE TABLE passengers;
TRUNCATE TABLE trips;
set FOREIGN_KEY_CHECKS =1;

INSERT INTO cities (`name`,`state`,`day_rate`,`night_rate`) values
  ('Banglore','Karnataka',50,75),
  ('Pune','Maharashtra',50,70);

INSERT INTO drivers (`name`,`age`,`gender`) values
  ('Bharat',25,'MALE'),
  ('Sachin',25,'MALE');

INSERT INTO cars (`make`,`model`,`year`,`type`,`drivers_id`,`cities_id`) values
  ('TOYOTA','INNOVA',2012,'LUX',1,1),
  ('TATA','NANO',2012,'NORMAL',1,2);

INSERT INTO passengers (`name`,`age`,`gender`,`credit`,`cities_id`) values
  ('Sumit',25,'MALE',1000,1),
  ('Dinesh',27,'MALE',10000,1);

INSERT INTO trips (`trip_type`,`distance_travelled`,`fare`,`tip_percent`,`final_fare`,`cars_id`,`passengers_id`,`drivers_id`) VALUES
  ('DAY',4,200,5,210,1,1,1),
  ('DAY',4,200,5,210,2,2,2),
  ('DAY',4,200,5,210,1,2,1);
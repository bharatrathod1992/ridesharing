package com.allstate.services;

import com.allstate.entities.*;
import com.allstate.enums.CarType;
import com.allstate.enums.TripType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CarServiceTest {

    private CarService carService;
    private DriverService driverService;
    private CityService cityService;
    private PassengerService passengerService;
    private TripService tripService;

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Autowired
    public void setTripService(TripService tripService) {
        this.tripService = tripService;
    }

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCar(){
        Driver d = this.driverService.find(1);
        City city = this.cityService.find(1);
        Car car = new Car("TATA","NANO",2014, CarType.NORMAL);
        car.setDriver(d);
        car.setCity(city);
        Car after = this.carService.create(car);//actually this line wants driver_id
        assertNotNull(after);
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void shouldNotCreateCarIfNoCityProvided(){
        Driver d = this.driverService.find(1);
        City city = this.cityService.find(1);
        Car car = new Car("TATA","NANO",2014, CarType.NORMAL);
        car.setDriver(d);
        Car after = this.carService.create(car);
    }

    @Test
    public void shouldFindCityById() {
        Car after = this.carService.find(1);
        assertEquals("TOYOTA",after.getMake());
    }

    @Test
    public void shouldNotFindCityWithBadId() {
        Car after = this.carService.find(5);
        assertNull(after);
    }

    @Test
    @Transactional
    public void shouldFindTheDriverWhoDriveTheCar() {
        Driver driver = this.carService.find(1).getDriver();
        assertEquals(1,driver.getId());
    }

    @Test
    @Transactional
    public void shouldFindAllTheTripsForTheCar() {

        Trip before1 = new Trip(TripType.DAY, 20);
        Car car = this.carService.find(1);
        Passenger passenger = this.passengerService.find(2);
        before1.setCar(car);
        before1.setDriver(this.driverService.find(1));
        before1.setPassenger(passenger);
        before1.setTipPercent(10);
        Trip first = this.tripService.addTrip(before1);

        Trip before2 = new Trip(TripType.DAY, 20);
        Car car2 = this.carService.find(1);
        Passenger passenger2 = this.passengerService.find(2);
        before2.setCar(car2);
        before2.setDriver(this.driverService.find(1));
        before2.setPassenger(passenger2);
        before2.setTipPercent(10);
        Trip second = this.tripService.addTrip(before2);

        List<Trip> trips = this.carService.find(1).getTrips();
        assertEquals(4,trips.size());
    }
}
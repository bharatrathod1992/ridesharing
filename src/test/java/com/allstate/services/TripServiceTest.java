package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import com.allstate.enums.TripType;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TripServiceTest {

    private TripService tripService;
    private CarService carService;
    private PassengerService passengerService;
    private DriverService driverService;

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Autowired
    public void setTripService(TripService tripService) {
        this.tripService = tripService;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateNewTrip() {
        Trip before = new Trip(TripType.DAY, 20);
        Car car = this.carService.find(1);
        Passenger passenger = this.passengerService.find(2);
        before.setCar(car);
        before.setDriver(this.driverService.find(1));
        before.setPassenger(passenger);
        before.setTipPercent(10);
        Trip after = this.tripService.addTrip(before);
        assertEquals(1100,after.getFinalFare(),0.1);
    }

    @Test
    @Transactional
    public void shouldNotCreateNewTripIfDriverIsBanned() {
        Trip before = new Trip(TripType.DAY, 20);
        Car car = this.carService.find(1);
        Driver driver = car.getDriver();
        this.driverService.violation(driver.getId());
        this.driverService.violation(driver.getId());
        this.driverService.violation(driver.getId());
        this.driverService.violation(driver.getId());
        Passenger passenger = this.passengerService.find(2);
        before.setCar(car);
        before.setPassenger(passenger);
        before.setTipPercent(10);
        Trip after = this.tripService.addTrip(before);
        assertNull(after);
    }

    @Test
    public void shouldFindACarForAParticularTrip() {
        Car car = this.tripService.find(1).getCar();
        assertEquals(1,car.getId());
    }

    @Test
    public void shouldFindAnotherCarForAnotherTrip() {
        Car car = this.tripService.find(2).getCar();
        assertEquals(2,car.getId());
    }

    @Test
    public void shouldFindADriverForTheTrip() {
        Driver driver = this.tripService.find(1).getDriver();
        assertEquals("Bharat",driver.getName());
    }

    @Test
    public void shouldFindAPassengerForTheTrip() {
        Passenger passenger = this.tripService.find(1).getPassenger();
        assertEquals("Sumit",passenger.getName());
    }

}
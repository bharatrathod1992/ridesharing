package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.enums.CarType;
import com.allstate.enums.Gender;
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
public class CarServiceTest {

    private CarService carService;
    private DriverService driverService;

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
        Car car = new Car("TATA","NANO",2014, CarType.NORMAL);
        car.setDriver(d);
        Car after = this.carService.create(car);//actually this line wants driver_id
        assertNotNull(after);
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
}
package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.entities.Trip;
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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class DriverServiceTest {

    private DriverService driverService;

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateDriver() {
        Driver before = new Driver("Karan",24, Gender.MALE);
        Driver after = this.driverService.create(before);
        assertNotNull(after);
    }

    @Test
    public void shouldFindDriverById() {
        Driver after = this.driverService.find(1);
        assertEquals("Bharat",after.getName());
        assertEquals(0,after.getNoOfViolation());
    }

    @Test
    public void shouldAddViolationIfCaughtByPolice() {
        Driver driver = this.driverService.find(1);
        try {
            driver = this.driverService.violation(driver.getId());
        } catch (Exception e) {
        }
        assertEquals(1,driver.getNoOfViolation());
    }

    @Test
    public void shouldBannedTheDriverIfCaughtThreeTimesByPolice() {
        Driver driver = this.driverService.find(1);

        driver = this.driverService.violation(driver.getId());
        driver = this.driverService.violation(driver.getId());
        driver = this.driverService.violation(driver.getId());
        assertTrue(driver.isBanned());
    }

    @Test
    @Transactional
    public void shouldFindAllTheCarsDriverOwns() {
        List<Car> cars = this.driverService.find(1).getCars();
        assertEquals(2,cars.size());
    }


//    @Test
//    @Transactional
//    public void shouldFindAllTheCitiesForADriver() {
//        List<City> cities = this.driverService.find(1).getCities();
//
//        assertEquals(1,cities.size());
//    }

    @Test
    @Transactional
    public void shouldFindAllTripsForADriver() throws Exception{

        List<Trip> trips = this.driverService.find(1).getTrips();
        assertEquals(2,trips.size());

    }


}
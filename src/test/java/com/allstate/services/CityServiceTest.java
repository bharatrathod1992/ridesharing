package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CityServiceTest {

    private CityService cityService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCity() {
        City city = new City("Ranchi","Jharkhand",40,75);
        City after = this.cityService.create(city);
        assertNotNull(after);
    }

    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void shouldNotCreateCityWithBadParameter() throws Exception {
        City city = new City();
        city.setName("Pune");
        City after = this.cityService.create(city);
    }

    @Test
    public void shouldFindCityById() {
        City after = this.cityService.find(1);
        assertEquals("Banglore",after.getName());
    }

    @Test
    public void shouldFindCityByName() {
        City after = this.cityService.findByName("Banglore");
        assertEquals("Banglore",after.getName());
    }

    @Test
    public void shouldNotFindCityWithBadId() {
        City after = this.cityService.find(6);
        assertNull(after);
    }

    @Test
    @Transactional
    public void shouldFindAllPassengersOfBangloreCity() {
         List<Passenger> passengers = this.cityService.findByName("Banglore").getPassengers();
         assertEquals(2,passengers.size());
    }

    @Test
    @Transactional
    public void shouldFindAllPassengersOfPuneCity() {
        List<Passenger> passengers = this.cityService.findByName("Pune").getPassengers();
        assertEquals(0,passengers.size());
    }

    @Test
    @Transactional
    public void shouldFindAllDriversOfBangloreCity() {
        List<Driver> driversOfBangloreCity = this.cityService.findByName("Banglore").getDrivers();
        assertEquals(2,driversOfBangloreCity.size());
    }

}
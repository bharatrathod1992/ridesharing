package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class PassengerServiceTest {

    private PassengerService passengerService;
    private CityService cityService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreatePassenger() {
        Passenger passenger = new Passenger("Rakesh",25, Gender.MALE,2500);
        passenger.setCity(this.cityService.find(1));
        Passenger after = this.passengerService.create(passenger);
        assertNotNull(after);
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void shouldNotCreatePassengerIfCityIsNotSet() {
        Passenger passenger = new Passenger("Rakesh",25, Gender.MALE,2500);
        Passenger after = this.passengerService.create(passenger);
    }

    @Test
    public void shouldFindPassengerById() {
        Passenger after = this.passengerService.find(1);
        assertEquals("Sumit",after.getName());
    }

    @Test
    public void shouldFindTheCityOfThePassenger() {
        City city = this.passengerService.find(1).getCity();
        assertEquals("Banglore",city.getName());
    }

}
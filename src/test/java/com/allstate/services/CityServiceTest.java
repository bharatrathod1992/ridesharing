package com.allstate.services;

import com.allstate.entities.City;
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
    public void shouldNotFindCityWithBadId() {
        City after = this.cityService.find(6);
        assertNull(after);
    }

}
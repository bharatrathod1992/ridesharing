package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.enums.CarType;
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
public class CarServiceTest {

    private CarService carService;

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
        Car car = new Car("TATA","NANO",2014, CarType.NORMAL);
        Car after = this.carService.create(car);
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

}
package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.repositories.ICarRepository;
import com.allstate.repositories.ICityRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private ICarRepository carRepository;

    @Autowired
    public void setCarRepository(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(Car car) {
        return this.carRepository.save(car);
    }

    public Car find(int id) {
        return this.carRepository.findOne(id);
    }
}

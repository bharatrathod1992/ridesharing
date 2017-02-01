package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.repositories.IDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    private IDriverRepository driverRepository;

    @Autowired
    public void setDriverRepository(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver find(int id) {
        return this.driverRepository.findOne(id);
    }

    public Driver violation(int id){
        Driver result = this.driverRepository.findOne(id);

        if((result.getNoOfViolation())>=2) {
            result.setNoOfViolation(result.getNoOfViolation()+1);
            result.setBanned(true);
            this.driverRepository.save(result);
        }
        else{
            result.setNoOfViolation(result.getNoOfViolation()+1);
            this.driverRepository.save(result);
        }
        return result;
    }

    public Driver create(Driver driver) {
        return this.driverRepository.save(driver);
    }
}

package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import com.allstate.repositories.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TripService {

    private ITripRepository tripRepository;

    @Autowired
    public void setTripRepository(ITripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }


    public Trip addTrip(Trip trip) {

        boolean isDriverBanned = trip.getCar().getDriver().isBanned();
        float passengerAvailbal = trip.getPassenger().getCredit();
        if(!isDriverBanned) {

            float fare = trip.getCar().getCity().getDayRate() * trip.getDistanceTravelled();
            float finalFare = ((trip.getTipPercent() * fare) / 100) + fare;

            if(passengerAvailbal >= finalFare) {
                trip.setFare(fare);
                trip.setFinalFare(finalFare);
                return this.tripRepository.save(trip);
            }
            else{
                System.out.println(">>>>>>>>>PASSENGER DON'T HAVE ENOUGH MONEY>>>>>>>>>>>>>>>>>>>>");
            }
        }
        else{
            System.out.println(">>>>>>>>>>>>>>YOU ARE BANNED >>>>>>>>>>>>>");
        }
        return null;
    }

    public Trip find(int id) {
        return this.tripRepository.findOne(id);
    }
}

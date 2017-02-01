package com.allstate.entities;

import com.allstate.enums.TripType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "trips")
@Data
public class Trip {
    private int id;
    private int version;
    private TripType tripType;
    private float distanceTravelled;
    private float fare;
    private int tipPercent;
    private float finalFare;
    private Car car;
    private Passenger passenger;
    private Date created;
    private Date modified;
    private Driver driver;

    public Trip() {
    }

    public Trip(TripType tripType, float distanceTravelled) {
        this.tripType = tripType;
        this.distanceTravelled = distanceTravelled;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Enumerated(EnumType.STRING)
    public TripType getTripType() {
        return tripType;
    }
    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    @ManyToOne
    @JoinColumn(name = "cars_id")
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    @JoinColumn(name = "passengers_id")
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @ManyToOne
    @JoinColumn(name = "drivers_id")
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}

package com.allstate.entities;

import com.allstate.enums.CarType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cars")
@Data
public class Car {

    private int id;
    private int version;
    private String make;
    private String model;
    private int year;
    private CarType type;
    private Date created;

    public Car() {
    }

    public Car(String make, String model, int year, CarType type) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
    }

    private Date modified;

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

    @NotNull
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    @NotNull
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @NotNull
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Enumerated(EnumType.STRING)
    @NotNull
    public CarType getType() {
        return type;
    }
    public void setType(CarType type) {
        this.type = type;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }
}

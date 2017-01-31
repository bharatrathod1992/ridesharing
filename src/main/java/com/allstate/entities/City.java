package com.allstate.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cities")

public class City {
    private int id;
    private int version;
    private String name;
    private String state;
    private float dayRate;
    private float nightRate;
    private Date created;
    private Date modified;

    public City() {
    }

    public City(String name, String state, float dayRate, float nightRate) {
        this.name = name;
        this.state = state;
        this.dayRate = dayRate;
        this.nightRate = nightRate;
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

    @NotNull
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @NotNull
    public float getDayRate() {
        return dayRate;
    }
    public void setDayRate(float dayRate) {
        this.dayRate = dayRate;
    }

    @NotNull
    public float getNightRate() {
        return nightRate;
    }
    public void setNightRate(float nightRate) {
        this.nightRate = nightRate;
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


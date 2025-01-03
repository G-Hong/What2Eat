package com.example.firstproject.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "userinfo")
public class Userinfo {
    @Id
    @Column(name = "user_id", nullable = false, length = 25)
    private String userId;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "bodyMass")
    private Float bodyMass;

    @Column(name = "muscleMass")
    private Float muscleMass;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "step")
    private Integer step;

    @Column(name = "day")
    private Integer day;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Userlist userlist;

    public Userlist getUserlist() {
        return userlist;
    }

    public void setUserlist(Userlist userlist) {
        this.userlist = userlist;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getBodyMass() {
        return bodyMass;
    }

    public void setBodyMass(Float bodyMass) {
        this.bodyMass = bodyMass;
    }

    public Float getMuscleMass() {
        return muscleMass;
    }

    public void setMuscleMass(Float muscleMass) {
        this.muscleMass = muscleMass;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

}
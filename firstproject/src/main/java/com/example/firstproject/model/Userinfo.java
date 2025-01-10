package com.example.firstproject.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "userinfo")
public class Userinfo {
    @Id
    @Column(name = "user_id", nullable = false, length = 25)
    private String userId;

    @Column(name = "start_date")
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

    //며칠차인지 계산
    public int calculateDay() {
        int day=  (int) ChronoUnit.DAYS.between(this.startDate, LocalDate.now());
        return day;
    }
}
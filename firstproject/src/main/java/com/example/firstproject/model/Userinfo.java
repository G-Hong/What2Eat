package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false)
    private Userlist userlist;

    @Column(name = "goal")
    private Float goal;

    @Column(name = "step_day")
    private Integer stepDay;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStepDay() {
        return stepDay;
    }

    public void setStepDay(Integer stepDay) {
        this.stepDay = stepDay;
    }

    public Float getGoal() {
        return goal;
    }

    public void setGoal(Float goal) {
        this.goal = goal;
    }

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
    //몇단계인지 계산
    public int calculateStep(){

        int day = this.day;

        if(day<=0){
            this.step = 0;
            this.stepDay = 0;
        }
        else if(1<=day && day<=3){
            this.stepDay = day;
            this.step = 1;
        }
        else if(day<=7){
            this.stepDay = day-3;
            this.step = 2;
        }
        else if(day<=14){
            this.stepDay = day-7;
            this.step = 3;
        }
        else if(day<=21){
            this.stepDay = day-14;
            this.step = 4;
        }
        else {
            this.stepDay = 0;
            this.step = 0;
        }
        return this.step;
    }

}
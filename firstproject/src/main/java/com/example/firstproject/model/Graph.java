package com.example.firstproject.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "graph")
public class Graph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "bodyMass")
    private Float bodyMass;

    @Column(name = "muscleMass")
    private Float muscleMass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Userlist user;

    public Userlist getUser() {
        return user;
    }

    public void setUser(Userlist user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

}
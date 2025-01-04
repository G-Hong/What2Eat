package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore; // 올바른 패키지

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

    @Column(name = "body_mass")
    private Float bodyMass;

    @Column(name = "muscle_mass")
    private Float muscleMass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Lazy 로딩 문제 방지
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
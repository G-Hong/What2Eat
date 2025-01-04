package com.example.firstproject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "userlist")
public class Userlist {
    @Id
    @Column(name = "user_id", nullable = false, length = 25)
    private String userId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Graph> graphs;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Graph> getGraphs() {
        return graphs;
    }

    public void setGraphs(List<Graph> graphs) {
        this.graphs = graphs;
    }
}
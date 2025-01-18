package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "userlist")
public class Userlist {
    @Id
    @Column(name = "user_id", nullable = false, length = 25)
    private String userId;

    @Column(name = "passwd", nullable = false, length = 25)
    private String passwd;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval =true, fetch = FetchType.LAZY)
    //@JsonManagedReference // 순환 참조 방지
    private List<Graph> graphs;

    public String getUserId() {
        return userId;
    }
    public String getPasswd() {return passwd;}

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public List<Graph> getGraphs() {
        return graphs;
    }
    public void setGraphs(List<Graph> graphs) {
        this.graphs = graphs;
    }
}
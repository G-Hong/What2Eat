package com.example.firstproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userlist")
public class Userlist {
    @Id
    @Column(name = "user_id", nullable = false, length = 25)
    private String userId;

    @Column(name = "passwd", nullable = false, length = 25)
    private String passwd;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
//    private List<Graph> graphs;

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

}
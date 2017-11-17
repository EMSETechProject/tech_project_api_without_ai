package com.robin.camarasa.nutritvecoach.model;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String pseudo;

    @Column(nullable = false)
    private String password;

    @SuppressWarnings("unused")
    public User() {
    }

    public User(String pseudo, String password) {
        this.password = password;
        this.pseudo = pseudo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

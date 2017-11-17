package com.robin.camarasa.nutritvecoach.web;

import com.robin.camarasa.nutritvecoach.model.User;


public class UserDto {

    private final Long id;
    private final String pseudo;
    private final String password;

    public UserDto(User user) {
        this.id = user.getId();
        this.pseudo = user.getPseudo();
        this.password = user.getPassword();
    }

    public Long getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getStatus() {
        return password;
    }
}
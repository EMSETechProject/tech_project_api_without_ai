package com.robin.camarasa.nutritvecoach.web.dto;

import com.robin.camarasa.nutritvecoach.model.PhysicalData;
import com.robin.camarasa.nutritvecoach.model.User;


public class UserConectionDto {

    private final Long id;

    public UserConectionDto(User user) {
        this.id = user.getId();
    }

    public Long getId() {
        return id;
    }
}
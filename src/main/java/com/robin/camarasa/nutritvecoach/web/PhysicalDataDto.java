package com.robin.camarasa.nutritvecoach.web;

import com.robin.camarasa.nutritvecoach.model.PhysicalData;
import com.robin.camarasa.nutritvecoach.model.User;


public class PhysicalDataDto {

    private final Long id;
    private final Float weight;
    private final Float size;
    private final Integer age;
    private final User user;

    public PhysicalDataDto(PhysicalData physicalData) {
        this.id = physicalData.getId();
        this.weight = physicalData.getWeight();
        this.size = physicalData.getSize();
        this.age = physicalData.getAge();
        this.user = physicalData.getUser();
    }

    public Float getSize() {
        return size;
    }

    public Float getWeight() {
        return weight;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Integer getAge() {
        return age;
    }

}
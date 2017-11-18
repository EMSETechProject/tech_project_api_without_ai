package com.robin.camarasa.nutritvecoach.model;

import javax.persistence.*;

@Entity
@SuppressWarnings("serial")
public class PhysicalData {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Float weight;

    @Column(nullable = false)
    private Float size;

    @Column(nullable = false)
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private User user;

    @SuppressWarnings("unused")
    public PhysicalData() {
    }

    public PhysicalData(Integer age, Float weight, Float size, User user) {
        this.age = age;
        this.weight = weight;
        this.size = size;
        this.user = user;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

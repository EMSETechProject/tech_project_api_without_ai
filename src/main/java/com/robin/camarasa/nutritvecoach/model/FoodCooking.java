package com.robin.camarasa.nutritvecoach.model;

import javax.persistence.*;
import java.util.List;

@Entity
@SuppressWarnings("serial")
public class FoodCooking {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Float weight;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Food food;

    @SuppressWarnings("unused")
    public FoodCooking() {
    }

    public FoodCooking(Float weight, Food food) {
        this.weight = weight;
        this.food = food;
    }

    public Long getId() {
        return id;
    }

    public Food getFood() {
        return food;
    }

    public Float getWeight() {
        return weight;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}

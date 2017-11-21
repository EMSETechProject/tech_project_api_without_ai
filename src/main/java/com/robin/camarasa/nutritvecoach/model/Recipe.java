package com.robin.camarasa.nutritvecoach.model;

import javax.persistence.*;
import java.util.List;

@Entity
@SuppressWarnings("serial")
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<FoodCooking> foodCookings;

    @SuppressWarnings("unused")
    public Recipe() {
    }

    public Recipe(String name, List<FoodCooking> foodCookings) {
        this.name = name;
        this.foodCookings = foodCookings;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public List<FoodCooking> getFoodCookings() {
        return foodCookings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFoodCookings(List<FoodCooking> foodCookings) {
        this.foodCookings = foodCookings;
    }
}

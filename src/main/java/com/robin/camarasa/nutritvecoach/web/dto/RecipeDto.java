package com.robin.camarasa.nutritvecoach.web.dto;

import com.robin.camarasa.nutritvecoach.model.FoodCooking;
import com.robin.camarasa.nutritvecoach.model.PhysicalData;
import com.robin.camarasa.nutritvecoach.model.Food;
import com.robin.camarasa.nutritvecoach.model.Recipe;

import java.util.List;

public class RecipeDto {

    private final Long id;
    private final String name;
    private final List<FoodCooking> foodCookings;

    public RecipeDto(Recipe recipe) {
        this.id = recipe.getId();
        this.name = recipe.getName();
        this.foodCookings = recipe.getFoodCookings();
    }

    public Long getId() {
        return id;
    }

    public List<FoodCooking> getFoodCookings() {
        return foodCookings;
    }

    public String getName() {
        return name;
    }
}
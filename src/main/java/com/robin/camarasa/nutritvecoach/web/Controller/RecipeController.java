package com.robin.camarasa.nutritvecoach.web.Controller;

import com.robin.camarasa.nutritvecoach.dao.FoodCookingDao;
import com.robin.camarasa.nutritvecoach.dao.FoodDao;
import com.robin.camarasa.nutritvecoach.dao.RecipeDao;
import com.robin.camarasa.nutritvecoach.model.FoodCooking;
import com.robin.camarasa.nutritvecoach.model.Recipe;
import com.robin.camarasa.nutritvecoach.web.dto.FoodCookingDto;
import com.robin.camarasa.nutritvecoach.web.dto.RecipeDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "/api/recipes")
@Transactional
public class RecipeController {

    private final RecipeDao recipeDao;
    private final FoodCookingDao foodCookingDao;
    private final FoodDao foodDao;


    public RecipeController(RecipeDao recipeDao, FoodCookingDao foodCookingDao, FoodDao foodDao) {
        this.recipeDao = recipeDao;
        this.foodCookingDao = foodCookingDao;
        this.foodDao = foodDao;
    }

    @PostMapping(value = "/add/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeDto addRecipe(@PathVariable String name) {
        return (new RecipeDto(new Recipe(name)));
    }

    @PostMapping(value = "/addingredient/{id_recipe}/{id_food}/{quantity}")
    @ResponseStatus(HttpStatus.CREATED)
    public FoodCookingDto addIngredient(@PathVariable Long id_recipe, @PathVariable Long id_food, @PathVariable Float quantity) {
        return (new FoodCookingDto(new FoodCooking(quantity,foodDao.findOne(id_food),recipeDao.findOne(id_recipe))));
    }
}

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
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping(value = "/all")
    public List<RecipeDto> getallrecipes() {
        return recipeDao.findAll().stream().map(RecipeDto::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/add/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeDto addRecipe(@PathVariable String name) {
        Recipe recipe = new Recipe(name);
        recipeDao.save(recipe);
        return (new RecipeDto(recipe));
    }

    @PostMapping(value = "/addingredient/{id_recipe}/{id_food}/{quantity}")
    @ResponseStatus(HttpStatus.CREATED)
    public FoodCookingDto addIngredient(@PathVariable Long id_recipe, @PathVariable Long id_food, @PathVariable Float quantity) {
        FoodCooking foodCooking = new FoodCooking(quantity,foodDao.findOne(id_food),recipeDao.findOne(id_recipe));
        foodCookingDao.save(foodCooking);
        return (new FoodCookingDto(foodCooking));
    }
}

package com.robin.camarasa.nutritvecoach.web;

import com.robin.camarasa.nutritvecoach.dao.FoodDao;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/foods")
@Transactional
public class FoodController {

    private final FoodDao foodDao;

    public FoodController(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @GetMapping(value = "/all")
    public List<FoodDto> getallfood() {
        return foodDao.findAll().stream().map(FoodDto::new).collect(Collectors.toList());
    }
}

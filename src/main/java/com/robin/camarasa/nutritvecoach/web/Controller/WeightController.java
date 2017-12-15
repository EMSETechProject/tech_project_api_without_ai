package com.robin.camarasa.nutritvecoach.web.Controller;


import com.robin.camarasa.nutritvecoach.dao.UserDao;
import com.robin.camarasa.nutritvecoach.dao.WeightDao;
import com.robin.camarasa.nutritvecoach.model.User;
import com.robin.camarasa.nutritvecoach.model.Weight;
import com.robin.camarasa.nutritvecoach.web.dto.WeightDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/weights")
@Transactional
public class WeightController {

    private final WeightDao weightDao;
    private final UserDao userDao;

    public WeightController(WeightDao weightDao, UserDao userDao) {
        this.weightDao = weightDao;
        this.userDao = userDao;
    }


    @PostMapping(value = "/add/{id}/{value}")
    @ResponseStatus(HttpStatus.CREATED)
    public WeightDto addWeight(@PathVariable Long id, @PathVariable Float value) {
        User user = userDao.getOne(id);
        Weight weight = new Weight(user,value);
        weightDao.save(weight);
        return (new WeightDto(weight));
    }

    @GetMapping(value = "/all")
    public List<WeightDto> getallWeights() {
        return weightDao.findAll().stream().map(WeightDto::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/findlastten/{id}")
    public List<WeightDto> getLastTen(@PathVariable Long id) {
        List<Weight> weights = weightDao.findAll();
        List<Weight> weights1 = new ArrayList<>();
        for (Weight weight : weights) {
            if(weight.getId() == id) {
                weights1.add(weight);
            }
        }
        List<Weight> weights2 = weights1.subList(Math.max(0,weights1.size()-10),weights1.size());
        return weights2.stream().map(WeightDto::new).collect(Collectors.toList());
    }
}

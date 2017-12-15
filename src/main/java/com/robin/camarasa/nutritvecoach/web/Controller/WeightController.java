package com.robin.camarasa.nutritvecoach.web.Controller;


import com.robin.camarasa.nutritvecoach.dao.UserDao;
import com.robin.camarasa.nutritvecoach.dao.WeightDao;
import com.robin.camarasa.nutritvecoach.model.User;
import com.robin.camarasa.nutritvecoach.model.Weight;
import com.robin.camarasa.nutritvecoach.web.dto.WeightDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

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
}

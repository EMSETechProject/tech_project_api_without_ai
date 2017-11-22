package com.robin.camarasa.nutritvecoach.web.Controller;

import com.robin.camarasa.nutritvecoach.dao.PhysicalDataDao;
import com.robin.camarasa.nutritvecoach.dao.UserDao;
import com.robin.camarasa.nutritvecoach.model.PhysicalData;
import com.robin.camarasa.nutritvecoach.model.User;
import com.robin.camarasa.nutritvecoach.web.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "/api/users")
@Transactional
public class UserController {

    private final UserDao userDao;
    private final PhysicalDataDao physicalDataDao;
    private PhysicalData physicalData;
    private User user;


    public UserController(UserDao userDao, PhysicalDataDao physicalDataDao) {
        this.userDao = userDao;
        this.physicalDataDao = physicalDataDao;
    }

    @GetMapping(value = "/{userId}")
    public UserDto get(@PathVariable Long userId) {
        return (new UserDto(userDao.getOne(userId)));
    }


    @PostMapping(value = "/add/{pseudo}/{password}/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto add(@PathVariable String pseudo, @PathVariable String password, @PathVariable Long id) {
        User user = new User(pseudo,password,physicalDataDao.findOne(id));
        userDao.save(user);
        return (new UserDto(user));
    }
}
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


    @PostMapping(value = "/initialisepassword/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto initialisePassword(@PathVariable Long userId) {
        User user = userDao.getOne(userId);
        user.setPassword("greiui78@");
        return (new UserDto(user));
    }

    @PostMapping(value = "/add/{pseudo}/{password}/{physicalid}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto add(@PathVariable String pseudo, @PathVariable String password, @PathVariable Long physicalid) {
        physicalData = physicalDataDao.getOne(physicalid);
        user = new User(pseudo,password,physicalData);
        userDao.save(user);
        return (new UserDto(user));
    }

}

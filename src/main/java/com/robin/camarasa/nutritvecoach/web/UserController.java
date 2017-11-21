package com.robin.camarasa.nutritvecoach.web;

import com.robin.camarasa.nutritvecoach.dao.PhysicalDataDao;
import com.robin.camarasa.nutritvecoach.dao.UserDao;
import com.robin.camarasa.nutritvecoach.model.PhysicalData;
import com.robin.camarasa.nutritvecoach.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
    public UserDto initialisePassword(@PathVariable Long userId) {
        User user = userDao.getOne(userId);
        user.setPassword("greiui78@");
        return (new UserDto(user));
    }

    @PostMapping(value = "/add/{pseudo}/{password}/{physicalid}")
    public UserDto add(@PathVariable String pseudo, @PathVariable String password, @PathVariable Long physicalid) {
        physicalData = physicalDataDao.getOne(physicalid);
        user = new User(pseudo,password,physicalData);
        userDao.save(user);
        return (new UserDto(user));
    }

}

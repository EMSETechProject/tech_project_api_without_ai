package com.robin.camarasa.nutritvecoach.web;

import com.robin.camarasa.nutritvecoach.dao.UserDao;
import com.robin.camarasa.nutritvecoach.model.User;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/users")
@Transactional
public class UserController {

    private final UserDao userDao;


    public UserController(UserDao userDao) {
        this.userDao = userDao;
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
}

package com.robin.camarasa.nutritvecoach.web.Controller;

import com.robin.camarasa.nutritvecoach.dao.PhysicalDataDao;
import com.robin.camarasa.nutritvecoach.dao.UserDao;
import com.robin.camarasa.nutritvecoach.dao.WeightDao;
import com.robin.camarasa.nutritvecoach.model.PhysicalData;
import com.robin.camarasa.nutritvecoach.model.User;
import com.robin.camarasa.nutritvecoach.model.Weight;
import com.robin.camarasa.nutritvecoach.web.dto.UserConnectionDto;
import com.robin.camarasa.nutritvecoach.web.dto.UserDto;
import com.robin.camarasa.nutritvecoach.web.dto.WeightDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/users")
@Transactional
public class UserController {

    private final UserDao userDao;
    private final PhysicalDataDao physicalDataDao;
    private final WeightDao weightDao;
    private PhysicalData physicalData;
    private User user;


    public UserController(UserDao userDao, PhysicalDataDao physicalDataDao, WeightDao weightDao) {
        this.userDao = userDao;
        this.physicalDataDao = physicalDataDao;
        this.weightDao = weightDao;
    }

    @GetMapping(value = "/{userId}")
    public UserDto get(@PathVariable Long userId) {
        return (new UserDto(userDao.getOne(userId)));
    }



    @GetMapping(value = "/test")
    public List<UserDto> test() {
        return userDao.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/all")
    public List<UserDto> getall() {
        return userDao.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/{pseudo}/{password}")
    public UserConnectionDto checkconnection(@PathVariable String pseudo, @PathVariable String password) {
        List<User> users = userDao.findAll();
        for (int i = 0; i < users.size() ; i++) {
            if (users.get(i).getPassword().equalsIgnoreCase(password) && users.get(i).getPseudo().equalsIgnoreCase(pseudo)) {
                return (new UserConnectionDto(users.get(i).getId()));
            }
        }
        return (new UserConnectionDto(-1l));
    }

    @PostMapping(value = "/add/weight/{id}/{value}")
    @ResponseStatus(HttpStatus.CREATED)
    public WeightDto addWeight(@PathVariable Long id, @PathVariable Float value) {
        User user = userDao.getOne(id);
        Weight weight = new Weight(user,value);
        weightDao.save(weight);
        return (new WeightDto(weight));
    }

    @PostMapping(value = "/add/{pseudo}/{password}/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto add(@PathVariable String pseudo, @PathVariable String password, @PathVariable Long id) {
        PhysicalData physicalData = physicalDataDao.getOne(id);
        User user = new User(pseudo,password,physicalData);
        userDao.save(user);
        return (new UserDto(user));
    }

    @GetMapping(value = "/weights/all")
    public List<WeightDto> getallWeights() {
        return weightDao.findAll().stream().map(WeightDto::new).collect(Collectors.toList());
    }
}
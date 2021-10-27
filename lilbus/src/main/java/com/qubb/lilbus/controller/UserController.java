package com.qubb.lilbus.controller;

import com.qubb.lilbus.model.User;
import com.qubb.lilbus.service.implementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImplementation userServiceImplementation;

    @Autowired
    public UserController(UserServiceImplementation userServiceImplementation) {
        this.userServiceImplementation = userServiceImplementation;
    }

    @GetMapping
    public List<User> getUsers() {
        return (List<User>) userServiceImplementation.list();
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userServiceImplementation.get(id);
    }

    @GetMapping("/get/phone/{phoneNumber}")
    public User getUserByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return userServiceImplementation.getUserByPhoneNumber(phoneNumber);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userServiceImplementation.delete(id);
    }

    @PostMapping("/save")
    public void addUser(@RequestBody User user) {
        userServiceImplementation.create(user);
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody User user) {
        userServiceImplementation.update(user);
    }

}

//package com.qubb.lilbus.controllers;
//
//import com.qubb.lilbus.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("api/users")
//public class UserController {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public List<User> getUsers() {
//        return userService.getUsers();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<User> getUser(@PathVariable Integer id) {
//        return userService.getUser(id);
//    }
//
//    @PostMapping
//    public void registerNewUser(@RequestBody User user) {
//        userService.createUser(user);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable Integer id) {
//        userService.deleteUser(id);
//    }
//}

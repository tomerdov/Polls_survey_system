package com.user.controller;

import com.user.model.User;
import com.user.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Long createUser(@RequestBody User user) throws Exception {
       return userService.createUser(user);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) throws Exception {
        userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable long id) throws Exception {
        userService.deleteUserById(id);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/register/{id}")
    public String registerUser(@PathVariable Long id) throws Exception {
        userService.registerUser(id);
        return "User registered successfully";
    }

}

package com.app.tera.user.controller;

import com.app.tera.user.model.User;
import com.app.tera.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("com/app/tera/user")
public class UserController {

    @Autowired
    UserService userService;

    @PutMapping("/registration")
    public User userRegistration(@RequestBody User user){
        return userService.saveUser(user);
    }

}

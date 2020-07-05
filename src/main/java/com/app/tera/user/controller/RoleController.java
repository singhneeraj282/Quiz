package com.app.tera.user.controller;

import com.app.tera.user.model.Role;
import com.app.tera.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("com/app/tera/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PutMapping("/addRole")
    public Role userRegistration(@RequestBody Role role){
        return roleService.saveRole(role);
    }
}

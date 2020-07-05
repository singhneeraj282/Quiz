package com.app.tera.user.service;

import com.app.tera.user.dao.RoleRepository;
import com.app.tera.user.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }
}

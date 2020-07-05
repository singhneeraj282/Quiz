package com.app.tera.user.service;

import com.app.tera.user.dao.RoleRepository;
import com.app.tera.user.dao.UserRepository;
import com.app.tera.user.model.Role;
import com.app.tera.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User finByUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User finUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role role = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        return userRepository.save(user);
    }

}

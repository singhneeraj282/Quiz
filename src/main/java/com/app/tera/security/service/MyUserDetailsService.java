package com.app.tera.security.service;

import com.app.tera.user.model.Role;
import com.app.tera.user.model.User;
import com.app.tera.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.finUserByUserName(userName);
        try {
            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
            return buildUserForAuthentication(user, authorities);
        } catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("user name not found");
        }
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        //Set<GrantedAuthority> roles = userRoles.stream().map(r->new SimpleGrantedAuthority(r.getRole())).collect(Collectors.toSet());
        /*for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }*/


        return userRoles.stream().map(r -> new SimpleGrantedAuthority(r.getRole())).collect(Collectors.toList());
        //return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                user.getActive(), true, true, true, authorities);
    }
}

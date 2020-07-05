package com.app.tera.user.dao;

import com.app.tera.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    public User findByEmail(String email);
    public User findByUserName(String userName);
}

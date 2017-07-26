package com.maxcheung.auth.service;

import com.maxcheung.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}

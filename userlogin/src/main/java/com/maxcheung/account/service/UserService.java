package com.maxcheung.account.service;

import com.maxcheung.account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    User updatePassword(String username, String password);
}

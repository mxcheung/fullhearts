package com.maxcheung.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxcheung.account.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

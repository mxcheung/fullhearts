package com.maxcheung.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxcheung.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}

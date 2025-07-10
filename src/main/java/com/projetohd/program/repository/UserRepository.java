package com.projetohd.program.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetohd.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
}

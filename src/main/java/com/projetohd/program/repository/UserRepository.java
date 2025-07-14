package com.projetohd.program.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetohd.entities.Clients;
import com.projetohd.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    public void deleteById(Long id);
     Optional<User> findById(Long id);
     Optional<User> findByEmailAndPassword(String email, String password);

}

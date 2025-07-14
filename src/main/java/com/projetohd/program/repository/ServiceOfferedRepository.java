package com.projetohd.program.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetohd.entities.ServiceOffered;

public interface ServiceOfferedRepository extends JpaRepository<ServiceOffered, Long> {

    Optional<ServiceOffered> findById(Long id);
    Optional<ServiceOffered> findByName(String name);

    void deleteById(Long id);
    void deleteByName(String name);

   
}

package com.projetohd.program.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projetohd.entities.Clients;
@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {

    List<Clients> findByUsername(String username);

    Optional<Clients> findById(Long id);

    List<Clients> findAllByOrderByRegisteredDateAsc();
    @Query("SELECT c FROM Clients c ORDER BY c.registeredDate")
    List<Clients> findAllOrderedByRegisteredDate();

    Optional<Clients> findByEmailAndPassword(String email, String password);

}

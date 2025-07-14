package com.projetohd.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetohd.entities.ServiceOffered;
import com.projetohd.program.repository.ServiceOfferedRepository;

@Service
public class ServiceOfferedService {

    @Autowired
    private ServiceOfferedRepository serviceOfferedRepository;


    public void save(ServiceOffered service) {
        serviceOfferedRepository.save(service);
    }


    public Optional<ServiceOffered> existsByName(String name) {
        return serviceOfferedRepository.findByName(name);
    }


    public void deleteById(Long id) {
        serviceOfferedRepository.deleteById(id);
    }

    public void deleteByName(String name) {
        serviceOfferedRepository.deleteByName(name);
    }
    public Optional<ServiceOffered> findById(Long id) {
        return serviceOfferedRepository.findById(id);
    }

  
    public void deactivate(ServiceOffered service) {
        service.setActive(false);
        serviceOfferedRepository.save(service);
    }

    /** Reativa um serviço previamente inativado */
    public void activate(ServiceOffered service) {
        service.setActive(true);
        serviceOfferedRepository.save(service);
    }
}

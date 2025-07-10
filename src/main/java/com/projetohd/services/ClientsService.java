package com.projetohd.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetohd.entities.Clients;
import com.projetohd.program.repository.ClientsRepository;
@Service
public class ClientsService {
	
  private final ClientsRepository clientsRepository;
  
  public ClientsService(ClientsRepository clientsRepository) {
	
	this.clientsRepository = clientsRepository;
}
public void saveClient(Clients cl) {
	  clientsRepository.save(cl);
  }
  public List<Clients> findByName(String name) {
	  
	  return clientsRepository.findByName(name);
  }
}

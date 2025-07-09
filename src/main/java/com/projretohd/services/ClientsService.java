package com.projretohd.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.projretohd.entities.Clients;
import com.projretohd.program.repository.ClientsRepository;
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

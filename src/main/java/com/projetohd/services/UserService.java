package com.projetohd.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetohd.entities.User;
import com.projetohd.program.repository.UserRepository;

@Service
public class UserService {
      


	@Autowired
	private UserRepository userRepository;

  

	public void saveUser(User user) {

		userRepository.save(user);
	}

	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	public void deleteById(User user) {

		userRepository.deleteById(user.getId());

	}

	public Optional<User> findById(User user) {

		return userRepository.findById(user.getId());

	}

	public Boolean login(String email, String password) {
		Optional<User> optionalUser = userRepository.findByEmailAndPassword(email, password);

		if (optionalUser.isEmpty()) {
			return false;
		} else {

						return true;
			
		}
	}

	

}

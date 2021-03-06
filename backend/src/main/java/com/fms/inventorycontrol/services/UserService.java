package com.fms.inventorycontrol.services;

import java.util.List;
import java.util.Optional;

import com.fms.inventorycontrol.dto.UserDTO;
import com.fms.inventorycontrol.entities.User;
import com.fms.inventorycontrol.repositories.UserRepository;
import com.fms.inventorycontrol.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail(), objDto.getOffice(), objDto.getPassword());
	}
}

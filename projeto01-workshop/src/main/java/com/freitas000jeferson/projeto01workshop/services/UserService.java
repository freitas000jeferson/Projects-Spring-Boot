package com.freitas000jeferson.projeto01workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freitas000jeferson.projeto01workshop.domain.User;
import com.freitas000jeferson.projeto01workshop.dto.UserDTO;
import com.freitas000jeferson.projeto01workshop.repository.UserRepository;
import com.freitas000jeferson.projeto01workshop.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	public UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	/**
	public Optional<User> findById(String id){
		return  repository.findById(id);
	}
	*/
	public User findById1(String id) {
		User user= repository.findOne(id);
		if(user ==  null) {
			throw new ObjectNotFoundException("Objeto nao encontrado");
		}
		return user;	
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	public User update(User obj) {
		User newObj = repository.findOne(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	private void updateData(User newObj, User obj){
		newObj.setName(obj.getName());
		newObj.setIdade(obj.getIdade());
		newObj.setEmail(obj.getEmail());
		newObj.setCargo(obj.getCargo());
		
	}
	public User fromDTO(UserDTO objdto) {
		return new User(objdto.getId(), 
				objdto.getName(),
				objdto.getEmail(),
				objdto.getIdade(),
				objdto.getCargo()
				
				);
	}
	public void delete(String id) {
		findById1(id);
		repository.delete(id);
	}
}

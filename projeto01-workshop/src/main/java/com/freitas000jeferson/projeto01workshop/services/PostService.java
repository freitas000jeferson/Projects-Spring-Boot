package com.freitas000jeferson.projeto01workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freitas000jeferson.projeto01workshop.domain.Post;
import com.freitas000jeferson.projeto01workshop.repository.PostRepository;
import com.freitas000jeferson.projeto01workshop.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	public PostRepository repository;
	
	/**
	public Optional<User> findById(String id){
		return  repository.findById(id);
	}
	*/
	public Post findById1(String id) {
		Post post= repository.findOne(id);
		if(post ==  null) {
			throw new ObjectNotFoundException("Objeto nao encontrado");
		}
		return post;	
	}
	
}

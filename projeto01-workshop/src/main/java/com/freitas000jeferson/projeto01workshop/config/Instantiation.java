package com.freitas000jeferson.projeto01workshop.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.freitas000jeferson.projeto01workshop.domain.User;
import com.freitas000jeferson.projeto01workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		//repository.deleteAll();
		/**
		User u1=new User(null, "Alberto del Rio","alberto@gmail.com", 24,"DBA");
		User u2=new User(null, "Alice Lima","alide123@gmail.com", 27,"Programador");
		User u3=new User(null, "Mariana Barbosa","mariana@gmail.com", 20,"Design");
		User u4=new User(null, "Kleber Nascimento","klebernasc@gmail.com", 26,"Programador");
		List<User> users= new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		repository.saveAll(users);
		*/
	}

}

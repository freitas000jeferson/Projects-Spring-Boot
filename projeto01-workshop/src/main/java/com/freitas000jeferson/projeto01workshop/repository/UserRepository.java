package com.freitas000jeferson.projeto01workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.freitas000jeferson.projeto01workshop.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}

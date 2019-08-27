package com.freitas000jeferson.projeto01workshop.dto;

import java.io.Serializable;

import com.freitas000jeferson.projeto01workshop.domain.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private int idade;
	private String cargo;
	public UserDTO(){}
	public UserDTO(User obj) {
		this.id=obj.getId();
		this.name=obj.getName();
		this.cargo=obj.getCargo();
		this.idade=obj.getIdade();
		this.email=obj.getEmail();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	
}

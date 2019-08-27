package com.freitas000jeferson.projeto01workshop.resources;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.freitas000jeferson.projeto01workshop.domain.Post;
import com.freitas000jeferson.projeto01workshop.domain.User;
import com.freitas000jeferson.projeto01workshop.dto.UserDTO;
import com.freitas000jeferson.projeto01workshop.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<User> findAll(){
		return service.findAll();
	}
	@GetMapping("/dto")
	public List<UserDTO> findAllUserDTO(){
		List<User> list =  service.findAll();
		List<UserDTO> listDto=	list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return listDto;
	}
	/**
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") String id) {
		System.out.println("findById");
		Optional<User> user = service.findById(id);
		return (user != null)?ResponseEntity.ok(user.get()):ResponseEntity.notFound().build();
	}
	*/
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = service.findById1(id);
		
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objdto){
		User obj = service.fromDTO(objdto);
		obj = service.insert(obj);
		URI uri=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO objdto){
		User obj = service.fromDTO(objdto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}/posts",method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User obj = service.findById1(id);
		
		return ResponseEntity.ok().body(obj.getPosts());
	}

}

package com.freitas000jeferson.projeto01workshop.resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freitas000jeferson.projeto01workshop.domain.Post;
import com.freitas000jeferson.projeto01workshop.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	
	/**
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") String id) {
		System.out.println("findById");
		Optional<User> user = service.findById(id);
		return (user != null)?ResponseEntity.ok(user.get()):ResponseEntity.notFound().build();
	}
	*/
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById1(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}

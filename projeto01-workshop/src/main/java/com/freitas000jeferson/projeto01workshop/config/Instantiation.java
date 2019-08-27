package com.freitas000jeferson.projeto01workshop.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.freitas000jeferson.projeto01workshop.domain.Post;
import com.freitas000jeferson.projeto01workshop.domain.User;
import com.freitas000jeferson.projeto01workshop.dto.AuthorDTO;
import com.freitas000jeferson.projeto01workshop.dto.CommentDTO;
import com.freitas000jeferson.projeto01workshop.repository.PostRepository;
import com.freitas000jeferson.projeto01workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		
		User u1=new User(null, "Alberto del Rio","alberto@gmail.com", 24,"DBA");
		User u2=new User(null, "Alice Lima","alide123@gmail.com", 27,"Programador");
		User u3=new User(null, "Mariana Barbosa","mariana@gmail.com", 20,"Design");
		User u4=new User(null, "Kleber Nascimento","klebernasc@gmail.com", 26,"Programador");

		List<User> users= new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		/**versao 2 do sts
		 * userRepository.saveAll(users);*/
		userRepository.save(users);
		
		Post p1=new Post(null,sdf.parse("20/07/2019"), "Partiu Viagem", "vou viajar para São Paulo",new AuthorDTO( u1));
		Post p2=new Post(null,sdf.parse("21/07/2019"), "Conquista", "novo trabalho acertado!!!",new AuthorDTO( u1));
		Post p3=new Post(null,sdf.parse("22/07/2019"), "Felicidade", "vou me casar",new AuthorDTO( u2));
		
		CommentDTO c1 = new CommentDTO("Boa Viagem Mano",sdf.parse("20/07/2019"), new AuthorDTO(u3));
		CommentDTO c2 = new CommentDTO( "Vá com Deus",sdf.parse("20/07/2019"), new AuthorDTO(u4));
		CommentDTO c3 = new CommentDTO("Parabéns",sdf.parse("22/07/2019"), new AuthorDTO(u2));
		p1.getComments().addAll(Arrays.asList(c1,c2));
		p2.getComments().addAll(Arrays.asList(c3));
		p3.getComments().addAll(Arrays.asList(c3));
		
		List<Post> posts= new ArrayList<Post>();
		posts.add(p1);
		posts.add(p2);
		posts.add(p3);
		
		postRepository.save(posts);
		
		u1.getPosts().addAll(Arrays.asList(p1,p2));
		u2.getPosts().add(p3);
		userRepository.save(u1);
		userRepository.save(u2);
		
		
		
	}

}

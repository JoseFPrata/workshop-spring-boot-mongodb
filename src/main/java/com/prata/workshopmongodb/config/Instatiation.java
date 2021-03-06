package com.prata.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.prata.workshopmongodb.domain.Post;
import com.prata.workshopmongodb.domain.User;
import com.prata.workshopmongodb.dto.AuthorDTO;
import com.prata.workshopmongodb.repository.PostRepository;
import com.prata.workshopmongodb.repository.UserRepository;

public class Instatiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userReposiroty;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		postRepository.deleteAll();
		User maria = new User("_id", "Maria Brown", "maria@gmail.com");
		User alex = new User("_id", "Alex Green", "alex@gmail.com");
		User bob = new User("_id", "Bob Grey", "bob@gmail.com");
		
		userReposiroty.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo!abs",new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo!abs",new AuthorDTO(maria));
		
	
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userReposiroty.save(maria);
		
		
	
	
	}	

}

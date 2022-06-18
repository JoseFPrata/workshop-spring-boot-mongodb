package com.prata.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.prata.workshopmongodb.domain.User;
import com.prata.workshopmongodb.repository.UserRepository;

public class Instatiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userReposiroty;

	@Override
	public void run(String... args) throws Exception {
		
		userReposiroty.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
		
	}
	
	

}

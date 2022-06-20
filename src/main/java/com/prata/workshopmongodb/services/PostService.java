package com.prata.workshopmongodb.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prata.workshopmongodb.domain.Post;

import com.prata.workshopmongodb.repository.PostRepository;
import com.prata.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	
	@Autowired
	private PostRepository repo;
	
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	
	
}

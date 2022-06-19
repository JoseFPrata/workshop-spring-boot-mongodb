package com.prata.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prata.workshopmongodb.domain.User;
import com.prata.workshopmongodb.dto.UserDTO;
import com.prata.workshopmongodb.repository.UserRepository;
import com.prata.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
		
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	public User insert(User obj) {
		return repo.insert(obj);
				
	}
	
	public User delete(String id) {
		findById(id);
		repo.deleteById(id);
		return null;
		
	}
	
	/* Para atualizar tem que fazer os dois métodos abaixo pois o 1o Update encontra e o 2o updateData atualiza  
	 * Deve-se perceber que no 2o não se copia o id pois esse não muda
	 * */
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}
	

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(), objDto.getEmail());
		
	}
}

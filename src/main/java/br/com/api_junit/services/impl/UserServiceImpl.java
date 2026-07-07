package br.com.api_junit.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api_junit.domain.User;
import br.com.api_junit.domain.dto.UserDTO;
import br.com.api_junit.repositories.UserRepository;
import br.com.api_junit.services.UserService;
import br.com.api_junit.services.exceptions.DataIntegrityViolationException;
import br.com.api_junit.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepository repository;

	@Override
	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);	
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	@Override
	public List<User> findAll(){
		return repository.findAll();
	}

	@Override
	public User create(UserDTO obj) {
		findByEmail(obj);
		return repository.save(mapper.map(obj, User.class));
	}

	@Override
	public User update(UserDTO obj) {
		findByEmail(obj);
		return repository.save(mapper.map(obj, User.class));
	}
	
	@Override
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

	private void findByEmail(UserDTO obj) {
		Optional<User> user = repository.findByEmail(obj.getEmail());
		if(user.isPresent() && !user.get().getId().equals(obj.getId())) throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
	}
}

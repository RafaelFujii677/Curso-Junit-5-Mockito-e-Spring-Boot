package br.com.api_junit.services;

import java.util.List;

import br.com.api_junit.domain.User;
import br.com.api_junit.domain.dto.UserDTO;

public interface UserService {

	User findById(Integer id);
	List<User> findAll();
	User create(UserDTO obj);
	User update(UserDTO obj);
}

package br.com.api_junit.services;

import java.util.List;

import br.com.api_junit.domain.User;

public interface UserService {

	User findById(Integer id);
	List<User> findAll();

}

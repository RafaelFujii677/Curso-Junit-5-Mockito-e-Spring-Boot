package br.com.api_junit.services;

import br.com.api_junit.domain.User;

public interface UserService {

	User findById(Integer id);

}

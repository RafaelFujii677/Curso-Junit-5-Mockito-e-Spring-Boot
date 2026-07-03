package br.com.api_junit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api_junit.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

package com.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByUsernameContaining(String username);

	public User findOneById(int userId);

	public User findOneByUsername(String username);

	public User findOneByUsernameAndPassword(String username, String password);

}

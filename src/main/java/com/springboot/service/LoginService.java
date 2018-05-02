package com.springboot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entities.User;
import com.springboot.repository.UserRepository;
import com.springboot.repository.custom.UserRepositoryNative;

@Service("loginService")
public class LoginService {
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRepositoryNative userRepositoryNative;

	public boolean updateUser(User user) {
		boolean updated = false;
		EntityManager entityManager = em;
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		transaction.commit();
		if (entityManager.isOpen())
			entityManager.close();
		return updated;
	}

	public List<User> getUsersBySQL(String username) {
		EntityManager entityManager = em;
		return userRepositoryNative.findByUsernameLikeSQL(entityManager, username);
	}
	
	public List<User> getUsersByHQL(String username) {
		EntityManager entityManager = em;
		return userRepositoryNative.findByUsernameLikeHQL(entityManager, username);
	}
}
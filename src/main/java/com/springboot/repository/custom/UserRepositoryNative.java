package com.springboot.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.springboot.entities.User;

@Repository
public class UserRepositoryNative {

	public List<User> findByUsernameLikeSQL(EntityManager entityManager, String username) {
		List<User> userList = null;
		Session session = entityManager.unwrap(Session.class);
		StringBuilder stringQuery = new StringBuilder("SELECT * FROM users WHERE username LIKE :username");
		SQLQuery query = session.createSQLQuery(stringQuery.toString());
		query.setParameter("username", "%" + username + "%");

		query.setResultTransformer(Transformers.aliasToBean(User.class));
		userList = query.list();
		
		return userList;
	}

	public List<User> findByUsernameLikeHQL(EntityManager entityManager, String username) {
		List<User> userList = null;
		StringBuilder stringQuery = new StringBuilder("FROM User WHERE username LIKE :username");
		Query query = entityManager.createQuery(stringQuery.toString());
		query.setParameter("username", "%" + username + "%");

		userList = query.getResultList();
		return userList;
	}

	// @Query(value = "SELECT * FROM users WHERE id=?1", nativeQuery = true)
	// public User findOneById(int userId);
	//
	// @Query(value = "SELECT * FROM users WHERE username=?1 LIMIT 1",
	// nativeQuery = true)
	// public User findOneByUsername(String username);
	//
	// @Query(value =
	// "SELECT * FROM users WHERE username=?1 and password=?2 LIMIT 1",
	// nativeQuery = true)
	// public User findOneByUsernameAndPassword(String username, String
	// password);
	//
	// @Query(value =
	// "SELECT users.*,address.address FROM users users LEFT JOIN addresses address on address.userid=users.id",
	// nativeQuery = true)
	// public List<UserWithAddress> findUsersWithAddress();
}

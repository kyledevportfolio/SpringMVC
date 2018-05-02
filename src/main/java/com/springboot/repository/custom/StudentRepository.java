package com.springboot.repository.custom;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springboot.entities.Student;
import com.springboot.entities.User;

@Repository
@Transactional
public class StudentRepository {

	public boolean addStudent(EntityManager entityManager, Student student) {
		boolean result = false;

		entityManager.persist(student);
		
		return result;
	}

	public List<Student> getStudents(EntityManager em) {
		StringBuilder studentQuery = new StringBuilder("FROM Student");
		Query query = em.createQuery(studentQuery.toString());
		List<Student> studentList = query.getResultList();
		return studentList;
	}
	public Object getStudentById(EntityManager em, int id) {
		StringBuilder studentQuery = new StringBuilder("FROM Student WHERE id = :id ");
		Query query = em.createQuery(studentQuery.toString());
		query.setParameter("id",id);
		
		Object selectedStudent = query.getSingleResult();
		return selectedStudent;
	}

	public List<Student> deleteStudentById(EntityManager em, String[] id) {	
		ArrayList<Integer> students = new ArrayList<Integer>();
		for(String ids : id){
			Integer n = new Integer(Integer.parseInt(ids));
			System.out.println(n);
			students.add(n);
		}
		StringBuilder studentQuery = new StringBuilder("DELETE FROM Student WHERE id IN :id");
		Query query = em.createQuery(studentQuery.toString());
		query.setParameter("id",students);
		query.executeUpdate();
		System.out.println("DeLEtee");
		return null;
	}
	
	public boolean updateStudent(EntityManager em, Student student) {
		boolean result = false;

		em.merge(student);
		
		return result;
	}

	public List<Student> searchStudent(EntityManager em, String txtsearch) {
		StringBuilder stringQuery = new StringBuilder("FROM Student WHERE name LIKE :txtsearch ");
		Query query = em.createQuery(stringQuery.toString());
		query.setParameter("txtsearch", "%" + txtsearch + "%");
		List<Student> studentlist = query.getResultList();
		return studentlist;

	}
}

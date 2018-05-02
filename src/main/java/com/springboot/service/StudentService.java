package com.springboot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entities.Student;
import com.springboot.repository.custom.StudentRepository;

@Service
public class StudentService {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public boolean addUser(String name, String age) {
		boolean result = false;
		Student student = new Student();
		student.setName(name);
		student.setAge(Integer.parseInt(age));
		result = studentRepository.addStudent(em, student);
		
		return result;
	}

	public List<Student> getStudents() {
		return studentRepository.getStudents(em);
	}
	public Object getStudentById(int id) {
		return studentRepository.getStudentById(em, id);
	}

	public boolean updateStudent(String name, int age, int id) {
		boolean result = false;
		Student student = new Student();
		System.out.println(id);
		student.setId(id);
		student.setName(name);
		student.setAge(age);
		result = studentRepository.updateStudent(em, student);
			
		return result;
		
	}

	public List<Student> deleteStudentById(String[] id) {
		return studentRepository.deleteStudentById(em, id);
		
	}
	
	public List<Student> searchStudent(String searchtxt) {
		return studentRepository.searchStudent(em,searchtxt);

		
	}
}

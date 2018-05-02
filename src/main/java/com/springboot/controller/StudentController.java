package com.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.entities.Student;
import com.springboot.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/add")
	public String loadAddUserScreen(ModelMap map) {
		return listUser(map);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addUser(HttpServletRequest request, ModelMap map) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		studentService.addUser(name, age);
		return listUser(map);
	}
	
	@RequestMapping(value="/list")
	public String listUser(ModelMap map) {
		List<Student> studentList = studentService.getStudents();
		map.addAttribute("studentList", studentList);
		return "student/add";
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String removeStudent(HttpServletRequest request, ModelMap map) {
		String[] id = request.getParameterValues("id");
		studentService.deleteStudentById(id);
		return listUser(map);
	
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String loadUpdateUserScreen(HttpServletRequest request, ModelMap map) {
		int id = Integer.parseInt(request.getParameter("id"));
		Object selectedStudent = studentService.getStudentById(id);
		map.addAttribute("selectedstudent",selectedStudent);
		return "student/update"; 
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateUser(HttpServletRequest request, ModelMap map) {
		int id= Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		studentService.updateStudent(name,age,id);
		return listUser(map);
	}

	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String searchUser(HttpServletRequest request, ModelMap map) {
		String txtsearch = request.getParameter("txtsearch");
		List<Student> studentList = studentService.searchStudent(txtsearch);
		map.addAttribute("studentList", studentList);
		return "student/add";
	}

}

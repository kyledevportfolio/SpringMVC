package com.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.entities.User;
import com.springboot.entities.UserWithAddress;
import com.springboot.repository.UserRepository;
import com.springboot.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LoginService loginService;

	@RequestMapping("/")
	public String loadLoginScreen() {
		List<User> userList = userRepository.findByUsernameContaining("A");
		System.out.println("userList Size " + userList.size());
		for (User user : userList) {
			System.out.println("REP - " + user.toString());
		}
		List<User> userListSQL = loginService.getUsersBySQL("3");

		for (User user : userListSQL) {
			System.out.println("REP2 - " + user.toString());
		}
//		List<User> userListHQL = loginService.getUsersByHQL("2");
//		
//		for (User user : userListHQL) {
//			System.out.println("REP3 - " + user.toString());
//		}
		// List<UserWithAddress> userListWithAddress =
		// userRepositoryNative.findUsersWithAddress();
		//
		// for (UserWithAddress userWithAddress : userListWithAddress) {
		// System.out.println("REP33 - " + userWithAddress.toString());
		// }
		return "login/index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String executeLogin(HttpServletRequest request, ModelMap map) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("THIS IS USERNAME " + username + "  - " + password);
		map.addAttribute("mikiUser", username);
		map.addAttribute("mikiPassword", password);
		return "login/index";
	}

	// @RequestMapping(method = RequestMethod.POST)
	// public String executeLogin2(String username, String password) {
	// System.out.println("THIS IS USERNAME " + username + "  - " + password);
	// return "";
	// }
}
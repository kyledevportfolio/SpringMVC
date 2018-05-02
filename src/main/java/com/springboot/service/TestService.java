package com.springboot.service;

import org.springframework.stereotype.Service;

@Service("testService")
public class TestService {

	private String myName = "";

	public boolean validateUserInfo(String username) {
		boolean isValid = false;
		if (username.equals(myName))
			isValid = true;

		return isValid;
	}
	
	public void setMyName(String myName) {
		this.myName = myName;
	}
	
	public String getMyName() {
		return myName;
	}
}

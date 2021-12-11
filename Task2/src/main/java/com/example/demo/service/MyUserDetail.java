package com.example.demo.service;

import com.example.demo.model.User;

public class MyUserDetail{

	private static User user;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		MyUserDetail.user = user;
	}	
	

}

package com.example.demo.web.dto;

public  class UserRegistrationDto {
	
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private int assets;
	
	public UserRegistrationDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UserRegistrationDto(String firstname, String lastname, String email, String password, int assets) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.assets = assets;
	}
	
	public int getAssets() {
		return assets;
	}

	public void setAssets(int assets) {
		this.assets = assets;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

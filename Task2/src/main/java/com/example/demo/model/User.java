package com.example.demo.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstname;
	
	@Column(name = "last_name")
	private String lastname;
	
	private String email;
	private String password;
	private int assets;
	
	private boolean enabled;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles",
				joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

	public int getAssets() {
		return assets;
	}



	public void setAssets(int assets) {
		this.assets = assets;
	}



	public User(String firstname, String lastname, String email, String password, int assets, Collection<Role> roles) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.assets = assets;
		this.roles = roles;
	}


	

	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
}


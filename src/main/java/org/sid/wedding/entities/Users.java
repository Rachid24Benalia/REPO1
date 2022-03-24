package org.sid.wedding.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
	@Id 
	private String email;
	private String password;
	private boolean active;
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return email;
	}
	public void setUsername(String username) {
		this.email = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getActive() {
		return active;
	}
	public void setRole(boolean active) {
		this.active = active;
	}
	public Users(String username, String password,boolean active,String role) {
		super();
		this.email = username;
		this.password = password;
		this.active = active;
		this.role = role;

	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

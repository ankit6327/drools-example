package com.example.service.example.beans;

public class Systemuser {

	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private Systemuserrole systemUserRole;
	private boolean isActive;
	private boolean isTempPassword;
	private int invalidLoginAttempts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Systemuserrole getSystemUserRole() {
		return systemUserRole;
	}

	public void setSystemUserRole(Systemuserrole systemUserRole) {
		this.systemUserRole = systemUserRole;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isTempPassword() {
		return isTempPassword;
	}

	public void setTempPassword(boolean isTempPassword) {
		this.isTempPassword = isTempPassword;
	}

	public int getInvalidLoginAttempts() {
		return invalidLoginAttempts;
	}

	public void setInvalidLoginAttempts(int invalidLoginAttempts) {
		this.invalidLoginAttempts = invalidLoginAttempts;
	}

}
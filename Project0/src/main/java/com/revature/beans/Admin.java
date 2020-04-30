package com.revature.beans;

public class Admin {
	
	private String AdminUserName;
	private String AdminPassword;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String adminUserName, String adminPassword) {
		super();
		AdminUserName = adminUserName;
		AdminPassword = adminPassword;
	}

	public String getAdminUserName() {
		return AdminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		AdminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return AdminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [AdminUserName=" + AdminUserName + ", AdminPassword=" + AdminPassword + "]";
	}
	
	
	
}

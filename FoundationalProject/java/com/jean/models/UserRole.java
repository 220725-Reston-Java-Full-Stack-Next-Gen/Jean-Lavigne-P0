package com.jean.models;

public class UserRole {

	private int roleId;
	private String roleType;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(int roleId, String roleType) {
		super();
		this.roleId = roleId;
		this.roleType = roleType;
	}

	public UserRole(String roleType) {
		super();
		this.roleType = roleType;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getroleType() {
		return roleType;
	}

	public void setroleType(String roleType) {
		this.roleType = roleType;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roleType=" + roleType + "]";
	}

}

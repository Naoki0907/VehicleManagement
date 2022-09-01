package com.wfeel.entity;

public class DecorateUser {
	
	private int id;
	private String loginName;
	private String loginPwd;
	private String createTime;
	private String role;
	
	public DecorateUser(int id, String loginName, String loginPwd, String createTime, String role) {
		this.id = id;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.setCreateTime(createTime);
		this.role = role;
	}
	
	public DecorateUser(String loginName, String loginPwd) {
		this.loginName = loginName;
		this.loginPwd = loginPwd;
	}
	
	public DecorateUser() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}

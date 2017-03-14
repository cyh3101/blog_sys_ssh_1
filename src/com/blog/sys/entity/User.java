package com.blog.sys.entity;

import java.sql.Blob;

/**
 * Created by paddy on 2017/3/12.
 */
public class User {
	private String userName;
	private String password;
	private Integer age;
	private String email;
	private String phone;
	private Integer user_id;
	private Blob headImg;
	
	public User () {
	}
	
	public User (String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName () {
		return userName;
	}
	
	public void setUserName (String userName) {
		this.userName = userName;
	}
	
	public String getPassword () {
		return password;
	}
	
	public void setPassword (String password) {
		this.password = password;
	}
	
	public Integer getAge () {
		return age;
	}
	
	public void setAge (Integer age) {
		this.age = age;
	}
	
	public String getEmail () {
		return email;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	public String getPhone () {
		return phone;
	}
	
	public void setPhone (String phone) {
		this.phone = phone;
	}
	
	public Integer getUser_id () {
		return user_id;
	}
	
	public void setUser_id (Integer user_id) {
		this.user_id = user_id;
	}
	
	public Blob getHeadImg () {
		return headImg;
	}
	
	public void setHeadImg (Blob headImg) {
		this.headImg = headImg;
	}
	
	@Override
	public String toString () {
		return "User{" +
				"userName='" + userName + '\'' +
				'}';
	}
}

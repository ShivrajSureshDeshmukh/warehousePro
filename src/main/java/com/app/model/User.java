package com.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
@Entity
@Table(name="user_tbl")
public class User {

	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer id;
	@Column(name="uname")
	private String userName;
	@Column(name="umail")
	private String userEmail;
	@Column(name="upwd")
	private String userPassword;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="usr_roles_tab",
		joinColumns=@JoinColumn(name="uidFk")
	)
	@Column(name="roleName")
	private Set<String> roles=new HashSet<String>(0);

	//default Constructor
	public User() {
		super();
	}
	public User(Integer id, String userName, String userEmail, String userPassword, Set<String> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.roles = roles;
	}
	public User(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", roles=" + roles + "]";
	}
}

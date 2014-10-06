package com.tmon.front.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Member {

	@Id
	@Column(unique=false, nullable=false, length=20)
	private String id;
	@Column(nullable=false, length=20)
	private String password;
	@Column(nullable=false, length=40)
	private String name;
	@OneToMany(mappedBy="member", fetch=FetchType.EAGER)
	private Set<MemberRole> roles;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<MemberRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<MemberRole> roles) {
		this.roles = roles;
	}

	
	
	
	
}

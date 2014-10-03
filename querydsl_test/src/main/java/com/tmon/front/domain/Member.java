package com.tmon.front.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member {

	@Id
	@GeneratedValue
	private int seq;
	private String id;
	private String name;
	private String password;
	
	public Member(){}
	
	public Member(int seq, String id, String name, String password) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.password = password;
	}



	public int getSeq() {
		return seq;
	}



	public void setSeq(int seq) {
		this.seq = seq;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Member [seq=" + seq + ", id=" + id + ", name=" + name
				+ ", password=" + password + "]";
	}
	
	
	
}

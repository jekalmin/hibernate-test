package com.tmon.front.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member {

	@Id
	private int seq;
	private String id;
	private String name;
	private String password;
	
	
	
	@Override
	public String toString() {
		return "Member [seq=" + seq + ", id=" + id + ", name=" + name
				+ ", password=" + password + "]";
	}
	
	
	
}

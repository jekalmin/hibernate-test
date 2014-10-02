package com.tmon.front.domain;

/**
 * xml 기반의 하이버네이트 엔티티
 * xml 경로 : src/main/resources/hibernate/Customer.hbm.xml
 * @author jekalmin
 *
 */
public class Customer {

	private int seq;
	private String id;
	private String password;
	private String name;
	
	public Customer(){}
	
	public Customer(int seq, String id, String password, String name) {
		super();
		this.seq = seq;
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public int getSeq(){
		return seq;
	}
	@SuppressWarnings("unused")
	private void setSeq(int seq){
		this.seq = seq;
	}

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

	@Override
	public String toString() {
		return "Customer [seq=" + seq + ", id=" + id + ", password=" + password
				+ ", name=" + name + "]";
	}
	
	
	
}

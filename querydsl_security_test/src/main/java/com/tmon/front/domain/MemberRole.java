package com.tmon.front.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"memberId", "role"}))
public class MemberRole {
	
	private int seq;
	private Member member;
	private String role;
	
	@Id
	@GeneratedValue
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	@ManyToOne
	@JoinColumn(name="memberId")
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	@Column(nullable=false, length=50)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MemberRole [seq=" + seq + ", member=" + member + ", role="
				+ role + "]";
	}
	
	

}

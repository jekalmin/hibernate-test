package com.tmon.front.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Article {

	@Id
	@GeneratedValue
	private int articleNo;
	@JoinColumn(name="memberId")
	@OneToOne
	private Member member;
	private String title;
	private String content;
	
	@Override
	public String toString() {
		return "Article [articleNo=" + articleNo + ", member=" + member.getName()
				+ ", title=" + title + ", content=" + content + "]";
	}

	public int getArticleNo() {
		return articleNo;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}

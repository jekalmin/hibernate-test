package com.tmon.front.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Article {

	@Id
	private int articleNo;
	@JoinColumn(name="memberSeq")
	@OneToOne
	private Member member;
	private String title;
	private String content;
	
	@Override
	public String toString() {
		return "Article [articleNo=" + articleNo + ", member=" + member
				+ ", title=" + title + ", content=" + content + "]";
	}
	
	
}

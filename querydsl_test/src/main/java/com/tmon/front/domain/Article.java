package com.tmon.front.domain;

import javax.persistence.Column;
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
	
	public Article(){
	}
	public Article(int articleNo, int memberSeq, String title, String content) {
		super();
		this.articleNo = articleNo;
		this.title = title;
		this.content = content;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
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
	@Override
	public String toString() {
		return "Article [articleNo=" + articleNo + ", member=" + member
				+ ", title=" + title + ", content=" + content + "]";
	}
	
	
}

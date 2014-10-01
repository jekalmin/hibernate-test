package com.tmon.front.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Article {

	@Id
	@GeneratedValue
	private int articleNo;
	private int memberSeq;
	private String title;
	private String content;
	
	public Article(){
	}
	public Article(int memberSeq, String title, String content) {
		this.memberSeq = memberSeq;
		this.title = title;
		this.content = content;
	}
	private int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public int getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
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
		return "Article [articleNo=" + articleNo + ", memberSeq=" + memberSeq
				+ ", title=" + title + ", content=" + content + "]";
	}
	
	
}

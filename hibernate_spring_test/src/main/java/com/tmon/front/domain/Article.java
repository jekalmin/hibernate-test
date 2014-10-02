package com.tmon.front.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 어노테이션 기반의 하이버네이트 엔티티
 * @author jekalmin
 *
 */
@Entity
@Table
public class Article {

	@Id
	@Column
	private int articleNo;
	@Column
	private int memberSeq;
	@Column
	private String title;
	@Column
	private String content;
	
	public Article(){
	}
	public Article(int articleNo, int memberSeq, String title, String content) {
		super();
		this.articleNo = articleNo;
		this.memberSeq = memberSeq;
		this.title = title;
		this.content = content;
	}
	public int getArticleNo() {
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

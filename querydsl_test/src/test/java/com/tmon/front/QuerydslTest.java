package com.tmon.front;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysema.query.jpa.impl.JPAQuery;
import com.tmon.front.domain.Article;
import com.tmon.front.domain.QArticle;
import com.tmon.front.domain.QMember;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")
public class QuerydslTest {
	
	@Autowired
	EntityManagerFactory factory;
	
	@Test
	public void test(){
		JPAQuery query = new JPAQuery(factory.createEntityManager());
		
		QArticle article = QArticle.article;
		QMember member = QMember.member;
		
		List<Article> list = query.from(article).innerJoin(article.member, member).list(article);
		for(Article a : list){
			System.out.println(a);
		}
	}

}

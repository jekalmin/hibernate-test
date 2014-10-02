package com.tmon.front;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysema.query.jpa.impl.JPAQuery;
import com.tmon.front.domain.Article;
import com.tmon.front.domain.Member;
import com.tmon.front.domain.QArticle;
import com.tmon.front.domain.QMember;
import com.tmon.front.repository.ArticleRepository;
import com.tmon.front.repository.MemberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")
public class QuerydslTest {
	
	@Resource
	EntityManagerFactory factory;
	
	@Resource
	ArticleRepository articleRepository;
	
	@Resource
	MemberRepository memberRepository;
	
	@Test
	public void test(){
		JPAQuery query = new JPAQuery(factory.createEntityManager());
		
		QArticle qArticle = QArticle.article;
		QMember qMember = QMember.member;
		
		List<Article> list = query.from(qArticle)
								.innerJoin(qArticle.member, qMember)
								.where(qMember.seq.eq(2))
								.limit(3).list(qArticle);
		for(Article a : list){
			System.out.println(a);
		}
	}
	
	@Test
	public void list(){
		QArticle qArticle = QArticle.article;
		Iterable<Article> article = articleRepository.findAll(qArticle.content.eq("ㅋㅋㅋ1"));
		System.out.println(article);
	}
	
	/**
	 * 페이징 테스트
	 */
	@Test
	public void page(){
		QArticle qArticle = QArticle.article;
		Page<Article> page = articleRepository.findAll(new PageRequest(0, 3));
		System.out.println(page);
		for(Article article : page.getContent()){
			System.out.println(article);
		}
		
	}

}

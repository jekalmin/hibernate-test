package com.tmon.front;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tmon.front.domain.Article;
import com.tmon.front.domain.Member;
import com.tmon.front.domain.QArticle;
import com.tmon.front.repository.ArticleRepository;
import com.tmon.front.repository.MemberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")
public class QuerydslTest {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	EntityManagerFactory factory;
	
	@Resource
	ArticleRepository articleRepository;
	
	@Resource
	MemberRepository memberRepository;
	
	@Test
	public void customRepository(){
		logger.debug("page : {}",articleRepository.getArticleList("", 0));
	}
	
	@Test
	public void role(){
		Member member = memberRepository.findOne("min");
		logger.debug("member : {}", member);
		logger.debug("roles : {}", member.getRoles());
		
	}
	
//	@Test
//	public void test(){
//		JPAQuery query = new JPAQuery(factory.createEntityManager());
//		
//		QArticle qArticle = QArticle.article;
//		QMember qMember = QMember.member;
//		
//		List<Article> list = query.from(qArticle)
//								.innerJoin(qArticle.member, qMember)
//								.where(qMember.seq.eq(2))
//								.limit(3).list(qArticle);
//		for(Article a : list){
//			System.out.println(a);
//		}
//	}
	
	@Test
	public void list(){
		QArticle qArticle = QArticle.article;
		Iterable<Article> article = articleRepository.findAll();
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
	
//	@Test
//	public void save(){
//		Member member = new Member(1, "2", "aaa", "bbb");
//		Article article = new Article();
//		article.setContent("aaa");
//		article.setMember(member);
//		article.setTitle("bbbbbbbb");
//		articleRepository.save(article);
//		System.out.println(articleRepository.findAll());
//	}

}

package com.tmon.front;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tmon.front.domain.Article;
import com.tmon.front.repository.ArticleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")
public class JpaTest {
	
	@Autowired
	ArticleRepository repository;

	@Test
	public void insert(){
		System.out.println("test");
		repository.save(new Article(6, 1, "제목1", "내용1"));
		list();
	}
	
	@Test
	public void detail(){
		Article article = repository.findOne(2);
		System.out.println(article);
	}
	
	@Test
	public void list(){
		Iterable<Article> iter = repository.findAll();
		System.out.println(iter);
	}
	
	@Test
	public void update(){
		list();
		repository.save(new Article(1,1, "변경된제목", "변경된내용"));
		list();
	}
	
	@Test
	public void delete(){
		repository.delete(2);
		list();
	}
}

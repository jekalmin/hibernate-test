package com.tmon.front;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tmon.front.repository.ArticleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")
public class JpaTest {

	@Autowired
	ArticleRepository repository;
	
	@Test
	public void Test(){
		System.out.println(repository.findOne(1));
	}
}

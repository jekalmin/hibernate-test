package com.tmon.front;

import java.lang.reflect.Field;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tmon.front.domain.Article;
import com.tmon.front.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/application-config.xml"})
public class HibernateTest {

	SessionFactory factory;
	Session session;
	
	@Before
	public void before(){
		Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
		session = factory.openSession();
	}
	
	@After
	public void after(){
		session.close();
		factory.close();
	}
	
	@Test
	public void test() throws Exception{
		Article article = new Article(1,"1","1");
		
		Field field = Article.class.getDeclaredField("articleNo");
		System.out.println(field);
//		field.setAccessible(true);
		System.out.println(field.get(article));
		
	}
	
	@Test
	public void insert(){
		Customer c1 = new Customer();
		c1.setId("jekalmin");
		c1.setName("min");
		c1.setPassword("min");
		session.save(c1);
		
	}
	
	@Test
	public void insertArticle(){
		
		for(int i=0; i < 10; i++){
			Article article = new Article();
			article.setMemberSeq(1);
			article.setTitle("제목");
			article.setContent("내용");
			session.save(article);
		}
		
		list();
	}
	
	@Test
	public void detail(){
		Customer c1 = (Customer)session.get(Customer.class, 1);
		System.out.println(c1);
	}
	
	@Test
	public void list(){
//		SQLQuery query = session.createSQLQuery("select * from Customer");
		Query query = session.createQuery("from Article");
		List customers = query.list();
		for(Object customer : customers){
			System.out.println(customer);
		}
	}
	
	@Test
	public void update(){
		list();
		System.out.println("==============================================");
		Customer c1 = (Customer)session.get(Customer.class, 3);
		c1.setName("babo");
		session.update(c1);
		list();
	}
	
	@Test
	public void delete(){
		Customer c2 = (Customer)session.load(Customer.class, 3);
		session.delete(c2);
		session.flush();
		
//		Query q = session.createQuery("delete Customer where seq = 3");
//		q.executeUpdate();
		
		list();
	}
	
}

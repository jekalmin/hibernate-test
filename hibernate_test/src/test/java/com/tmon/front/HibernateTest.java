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
	
	/**
	 * 하이버네이트 설정 코드
	 */
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
	
	/**
	 * 엔티티에 set 메소드가 필요 없는 이유(private 필드 접근)
	 * private 필드에 접근 하는 법
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception{
		Article article = new Article(1,"1","1");
		
		Field field = Article.class.getDeclaredField("articleNo");
		System.out.println(field);
//		field.setAccessible(true);
		System.out.println(field.get(article));
		
	}
	
	/**
	 * 고객 등록
	 */
	@Test
	public void insert(){
		Customer c1 = new Customer();
		c1.setId("jekalmin");
		c1.setName("min");
		c1.setPassword("min");
		session.save(c1);
		
	}
	
	/**
	 * 글 등록
	 * articleNo는 @GeneratedValue 어노테이션에 의해 자동 생성
	 */
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
	
	/**
	 * 고객 상세 정보
	 */
	@Test
	public void detail(){
		Customer c1 = (Customer)session.get(Customer.class, 1);
		System.out.println(c1);
	}
	
	

	/**
	 * 리스트 :
	 * HQL(Hibernate Query Language)를 사용한 리스트 가져오기
	 * "from Article" 에서 Article은 클래스명과 동일해야됨 (대소문자구분)
	 */
	@Test
	@SuppressWarnings("rawtypes")
	public void list(){
//		SQLQuery query = session.createSQLQuery("select * from Customer");
		Query query = session.createQuery("from Article");
		List customers = query.list();
		for(Object customer : customers){
			System.out.println(customer);
		}
	}
	
	/**
	 * 고객 정보 수정
	 */
	@Test
	public void update(){
		list();
		System.out.println("==============================================");
		Customer c1 = (Customer)session.get(Customer.class, 3);
		c1.setName("babo");
		session.update(c1);
		list();
	}

	/**
	 * 고객 정보 삭제
	 */
	@Test
	public void delete(){
		Customer c2 = (Customer)session.load(Customer.class, 2);
		session.delete(c2);
		session.flush();
		
//		Query q = session.createQuery("delete Customer where seq = 3");
//		q.executeUpdate();
		
		list();
	}
	
}

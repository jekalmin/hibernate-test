package com.tmon.front;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/application-config.xml"})
public class HibernateTest {

	@Autowired
	SessionFactory factory;
//	Session session;
	
//	@Before
//	public void before(){
//		Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
//		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//		factory = configuration.buildSessionFactory(builder.build());
//		session = factory.openSession();
//	}
//	
//	@After
//	public void after(){
//		session.close();
//		factory.close();
//	}
	

	@Test
	public void test(){
		System.out.println("test");
		Session session = factory.openSession();
		Customer c1 = new Customer();
		c1.setId("jekalmin");
		c1.setName("min");
		c1.setPassword("min");
		session.save(c1);
		
//		Customer c2 = (Customer)session.get(Customer.class, 2);
//		System.out.println(c2);
	}
	
}

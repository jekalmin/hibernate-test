package com.tmon.front;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tmon.front.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/application-config.xml"})
public class HibernateTest {

	@Autowired
	SessionFactory factory;
	Session session;
	
	@Before
	public void before(){
		session = factory.openSession();
	}

	@Test
	public void insert(){
		System.out.println("test");
		Customer c1 = new Customer();
		c1.setId("jekalmin");
		c1.setName("min");
		c1.setPassword("min");
		session.save(c1);
	}
	
	@Test
	public void detail(){
		Customer c1 = (Customer)session.get(Customer.class, 2);
		Customer c2 = (Customer)session.load(Customer.class, 3);
		System.out.println(c1);
		System.out.println(c2);
	}
	
	@Test
	public void list(){
//		SQLQuery query = session.createSQLQuery("select * from Customer");
		Query query = session.createQuery("from Customer");
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

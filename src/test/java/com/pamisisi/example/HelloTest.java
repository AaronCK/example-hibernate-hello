package com.pamisisi.example;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.pamisisi.example.domain.annotations.Note;
import com.pamisisi.example.domain.annotations.User;
import com.pamisisi.example.util.HibernateUtil;

public class HelloTest {

	private Session session;
	
	/**
	 * 每次方法运行前获取 Session
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

	/**
	 * 测试 
	 */
	@Test
	public void test() {
		assertTrue("Hibernate 创建会话失败!", session.isOpen());
	}
	
	/**
	 * 添加用户
	 */
	//@Test
	public void addUser() {
		User u = new User();
		u.setUsername("alex");
		u.setPassword("123456");
		
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		System.out.println("Hibernate Session is Open: " + session.isConnected());
	}

	/**
	 * 添加日记
	 */
	//@Test
	public void addNote(){
		session.beginTransaction();
		//获取 OID 为 1 的 User 对象 
		User user = (User) session.createQuery("from User as u where u.id=:id")
				.setLong("id", 1).uniqueResult();
		//判断 user 实例的 OID 是否为 1
		assertEquals(1, user.getId().longValue());
		
		Note note = new Note();
		note.setUser(user);
		note.setContext("Hello, welcomte!".getBytes());
		note.setDate(new Date());
		
		session.save(note);
		session.getTransaction().commit();
		
		System.out.println("Hibernate Session is Open: " + session.isConnected());
	}
	
	@Test
	public void showNote() {
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Note> notes = session.createQuery("from Note as n where n.user=:user").setLong("user", 1).list();
		session.getTransaction().commit();
		for(Note n: notes) { 
			System.out.print("ID: " + n.getId());
			System.out.print("\t context: " + new String(n.getContext()));
			System.out.print("\t username: " + n.getUser().getUsername());
			System.out.println("\t date: " + n.getDate());
		}
	}
}

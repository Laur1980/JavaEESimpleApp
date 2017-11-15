package org.javaee.tutorial.test;

import static org.junit.Assert.*;

import org.javaee.tutorial.dao.BookDAO;
import org.javaee.tutorial.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class EclipseLinkTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	
	@Before
	public void setUp(){
		emf = Persistence.createEntityManagerFactory("chapter04PU");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	@After
	public void teadDown(){
		if(em != null)em.close();
		if(emf !=null)emf.close();
	}

	@Test
	public void testFindForJavaEE7Book()throws Exception{
		Book book = em.find(Book.class, 1L);
		System.out.println(book.getTitle());
		assertEquals("Beginning Java EE 6", book.getTitle());
	} 
	
	@Test
	public void shouldCreateH2G2Book()throws Exception{
		Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5,"1-84023-742-2", 354, "gogu_scriitorul@gmail.com");
		new BookDAO().insertBook(book);
		assertNotNull("ID should not be null",book.getId());
		book =  em.createNamedQuery("findBookByTitle",Book.class).getSingleResult();
		assertEquals("The Hitchhiker's Guide to the Galaxy",book.getDescription());
	}
	
	@Test(expected=Exception.class)
	public void shouldRaiseContraintViolationExceptionBecauseOfNullTitle(){
		Book book = new Book(null, null, 12.5,"1-84023-742-2", 354, "gogu_scriitorul$gmail.com");
		tx.begin();
		em.persist(book);
		tx.commit();
	}
	
}

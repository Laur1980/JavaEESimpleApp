package org.javaee.tutorial.main;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.javaee.tutorial.dao.BookDAO;
import org.javaee.tutorial.entity.Book;

public class EclipseLinkApp {
	
	public static void main(String [] args){
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction transaction = em.getTransaction();
		Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5,"1-84023-742-2", 354, "gogu_scriitorul@gmail.com");
		new BookDAO().insertBook(book);
	}
	
}

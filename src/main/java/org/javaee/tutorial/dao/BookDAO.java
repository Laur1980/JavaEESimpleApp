package org.javaee.tutorial.dao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.javaee.tutorial.entity.Book;

public class BookDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public BookDAO(){
		emf = Persistence.createEntityManagerFactory("chapter04PU");
		em = emf.createEntityManager();
	}
	
	public void insertBook(Book b){
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
			em.persist(b);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
	}
	
}

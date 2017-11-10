package org.javaee.tutorial.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EclipseLinkApp {
	
	public static void main(String [] args){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();	
		
	}
	
}

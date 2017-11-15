package org.javaee.tutorial.test;


import static org.junit.Assert.assertTrue;

import org.javaee.tutorial.entity.Book;
import org.javaee.tutorial.service.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest 
{
	
	private Weld weld;
	
	@Before
	public void setUp(){
		weld = new Weld();
	}
	
	@Test
	public void shouldCheckNumberIsMock(){
		WeldContainer container = weld.initialize();
		BookService bs = container.instance().select(BookService.class).get();
		Book book = bs.createBook("Title 2", "iada iada iada iada iada iada iada",35.5, 235,"vasile@gmail.com");
		assertTrue(book.getIsbn().startsWith("MOCK"));
	}
	
	@After
	public void tearDown(){
		if(weld != null) weld.shutdown();
	}
}

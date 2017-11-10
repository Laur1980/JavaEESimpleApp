package org.javaee.tutorial.main;

import org.javaee.tutorial.entity.Book;
import org.javaee.tutorial.service.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Hello world!
 *
 */
public class IntercetorApp 
{
    public static void main( String[] args )
    {
        Weld weld = new Weld(); 
	        WeldContainer container = weld.initialize();
	        BookService bs = container.instance().select(BookService.class).get();
	        Book book = bs.createBook("Title1", 40.35, "bla bla bla bla bla");
	        System.out.println(book);
        if(weld != null)weld.shutdown();
    }
}

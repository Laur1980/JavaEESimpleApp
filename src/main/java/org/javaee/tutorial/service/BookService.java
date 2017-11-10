package org.javaee.tutorial.service;

import javax.inject.Inject;

import org.javaee.tutorial.entity.Book;
import org.javaee.tutorial.qualifier.Loggable;
import org.javaee.tutorial.qualifier.ThirteenDigits;
import org.javaee.tutorial.util.NumberGenerator;

@Loggable
public class BookService {
	
	@Inject @ThirteenDigits
	private NumberGenerator numberGenerator;
	
	public Book createBook(String title, Double price, String description){
		Book book = new Book(title,description,price,numberGenerator.generateNumber());
		return book;
	}
	
}

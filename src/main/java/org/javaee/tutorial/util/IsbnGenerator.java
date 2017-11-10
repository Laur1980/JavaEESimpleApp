package org.javaee.tutorial.util;

import java.util.Random;
import java.util.logging.Logger;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import org.javaee.tutorial.qualifier.EightDigits;
import org.javaee.tutorial.qualifier.Loggable;

@Default
@EightDigits
public class IsbnGenerator implements NumberGenerator {
	
	@Inject
	private Logger logger;
	
	@Loggable
	public String generateNumber() {
		String isbn = "13-84356-"+new Random().nextInt();
		logger.info("Generated ISBN: "+isbn);
		return isbn;
	}

}

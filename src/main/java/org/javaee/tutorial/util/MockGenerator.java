package org.javaee.tutorial.util;

import java.util.Random;
import java.util.logging.Logger;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.javaee.tutorial.qualifier.Loggable;
import org.javaee.tutorial.qualifier.ThirteenDigits;

@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {
	
	@Inject
	private Logger logger;
	
	@Loggable
	public String generateNumber() {
		String mock = "MOCK - "+new Random().nextInt();
		logger.info("Generated mock: "+mock);
		return mock;
	}

}

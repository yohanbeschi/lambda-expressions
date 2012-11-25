package org.isk.gettingstarted;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class GettingStartedTest {
	
	/**
	 * Implements the method buildMessage() using an anonymous class.
	 */
	@Test
	public void oldWayWithAnonymousClass() {
		final FirstFunctionalInterface firstInterface = new FirstFunctionalInterface() {
			@Override
			public String buildMessage(String msg) {
				return "Hello " + msg;
			}
		};

		final String string = firstInterface.buildMessage("Carl");

		Assert.assertEquals("Hello Carl", string);
	}

	/**
	 * Implements the method buildMessage() using a lambda expression.
	 */
	@Test
	public void newWayWithLambdaExpression() {
		final FirstFunctionalInterface firstInterface = msg -> "Hello " + msg 
				                                         + " with a lambda expression";
		final String string = firstInterface.buildMessage("John");
		
		Assert.assertEquals("Hello John with a lambda expression", string);
	}
}


package org.isk.generics;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class GenericsLambdaTest {
	/**
	 * Generic Single Abstract Method used as an anonymous function no matter it's purpose.
	 */
	@Test
	public void genericLambda() {
		GenericsLambda<String, String> gl = msg -> "Hello " + msg + " with a lambda expression";
		final String string = gl.doSomething("John");
		
		Assert.assertEquals("Hello John with a lambda expression", string);
	}
}

package org.isk.generics;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class GenericLambdaWithEllipseTest {
	/**
	 * Embedded lambda expressions cluttering the code.
	 */
	@Test
	public void genericLambdaWithEllipse() {
           // Construit un message avec le nom, l’age et la ville
		final GenericsLambdaWithEllipse<Object, String> gle = array -> {
                // Retourne un message en fonction de l’âge
			final GenericsLambda<Integer, String> gl = age -> {
				if (age.intValue() < 40) {
					return "You are young";
				} else {
					return "You are still young";
				}
			};
			
			return "Hello " + array[0] + ", you live in " + array[2] + " and " + gl.doSomething((Integer)array[1]) + "!";
		};
		
		final String string = gle.doSomething("John", 20, "Paris");
		
		Assert.assertEquals("Hello John, you live in Paris and You are young!", string);
	}
}

package org.isk.defenders;


import org.isk.defenders.intro.Reader;
import org.isk.defenders.intro.ReaderImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class SimpleDefenderTest {
	/**
	 * Demonstrating the use of a defender method.
	 */
	@Test
	public void defender() {
		final Reader reader = new ReaderImpl("Java 8 - Lambda Expressions");
		
		Assert.assertEquals('J', reader.next());
		Assert.assertTrue(reader.hasNext());
		reader.skip(10);
		Assert.assertEquals('m', reader.next());
	}
}

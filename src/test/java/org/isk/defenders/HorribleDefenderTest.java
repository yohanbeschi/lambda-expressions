package org.isk.defenders;

import org.isk.defenders.inheritance.Reader;
import org.isk.defenders.inheritance.ReaderImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class HorribleDefenderTest {
	/**
	 * Use some kind of JavaBean where all the business logic
	 * is in the interface that it implements.
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

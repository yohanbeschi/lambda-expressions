package org.isk.defenders;

import org.isk.defenders.override.Reader;
import org.isk.defenders.override.StandardReaderImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class OverrideDefenderTest {
	/**
	 * The defender method defined in {@link Reader} is overridden in {@link StandardReaderImpl}
	 */
	@Test
	public void defender() {
		final Reader reader = new StandardReaderImpl("Java 8 - Lambda Expressions");
		
		Assert.assertEquals('J', reader.next());
		Assert.assertTrue(reader.hasNext());
		reader.skip(10);
		Assert.assertEquals('m', reader.next());
	}
}

package org.isk.mutables;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class MutableTest {
	/**
	 * A final mutable object can be modify during the execution of
	 * lambda expression.  
	 */
	@Test
	public void mutable() {
		final Mutable mutable = new Mutable();
		mutable.value = 0;

		Executor executor = () -> mutable.value++;

		Assert.assertEquals("1", 0, mutable.value);

		executor.exec();
		Assert.assertEquals("2", 1, mutable.value);
		
		executor.exec();
		Assert.assertEquals("3", 2, mutable.value);
		
		mutable.value++;
		Assert.assertEquals("4", 3, mutable.value);
	}
}

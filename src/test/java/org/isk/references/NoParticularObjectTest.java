package org.isk.references;

import org.isk.references.part3.CustomComparator;
import org.isk.references.part3.Number;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class NoParticularObjectTest {
	/**
	 * Reference method of an instance method of an arbitrary 
	 * object of a particular type.
	 */
	@Test
	public void test() {
		CustomComparator comparator = Number::compare;
		
		int result = comparator.compare(new Number(5), new Number(10));
		Assert.assertEquals(-1, result);
	}
}

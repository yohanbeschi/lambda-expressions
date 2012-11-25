package org.isk.scope;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class ScopeTest {
	private int classField = 1; 
	private final static int FINAL_STATIC_INT = 2;
	private final int FINAL_INT = 3;
	
	/**
	 * Scope of variables that can be used within a lambda expression.
	 */
	@Test
	public void scope() {
		final Mutable mutable = new Mutable();
		mutable.value = 4;
		
		int effectivelyFinalInt = 5;
		final int finalInt = 6;
		
		final Executor executor = arg -> {
			int localInt = 7;
			mutable.value++;

			// effectivelyFinalInt++;
			
			return ++this.classField 
					+ ScopeTest.FINAL_STATIC_INT 
					+ this.FINAL_INT
					+ effectivelyFinalInt 
					+ finalInt 
					+ --localInt
					+ arg;
		};		
		// effectivelyFinalInt++;
		
		Assert.assertEquals("1", 4, mutable.value);
		Assert.assertEquals("2", 31, executor.modify(7));
		Assert.assertEquals("3", 5, mutable.value);
		
		// effectivelyFinalInt++;
	}
}

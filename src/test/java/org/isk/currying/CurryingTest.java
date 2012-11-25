package org.isk.currying;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class CurryingTest {
	/**
	 * Currying without lambda expressions
	 */
	@Test
	public void curryingWithoutLambdaExpression() {
		Assert.assertEquals(1.5, this.divideByTwo(3), 0.00001);
		Assert.assertEquals(1, this.divideByThree(3), 0.00001);
	}
	public double divideByTwo(int x) {
		return this.divide(x, 2);
	}
	
	private double divideByThree(double x) {
		return this.divide(x, 3);
	}
	
	private double divide(double x, double y) {
		return x / y;
	}

	/**
	 * Currying with lambda expressions
	 */
	@Test
	public void curryingWithLambdaExpression() {
		final Division reduction = (x, y) -> x / y;
		
		final Reduction divisionByTwo = x -> reduction.divide(x, 2);
		final Reduction divisionByThree = x -> reduction.divide(x, 3);
		
		Assert.assertEquals(1.5, divisionByTwo.divide(3), 0.00001);
		Assert.assertEquals(1, divisionByThree.divide(3), 0.00001);
	}

}

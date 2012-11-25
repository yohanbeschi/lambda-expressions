package org.isk.pipelining;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class ChainedLambdaTest {
	/**
	 * In-lining lambda expressions definition
	 */
	@Test
	public void chain() {
		/* () -> {
               return () -> "ok";
           }
           */
		Node<FinalNode> node = () -> () -> "ok";
		
		Assert.assertEquals("ok", node.run().execute());
	}
}

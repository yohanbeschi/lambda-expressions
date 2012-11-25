package org.isk.references;

import org.isk.references.part2.Incrementer;
import org.isk.references.part2.ReferenceMethodInstance;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class ReferenceInstanceTest {
	/**
	 * Reference method of an instance method of a particular object.
	 */
	@Test	
	public void increment() {
		final ReferenceMethodInstance rmi = new ReferenceMethodInstance();
		
		// Incrémente la valeur de index de l’instance rmi
		int index = rmi.increment();
		Assert.assertEquals(1, index);
		
		final Incrementer incrementer = rmi::increment;
		
		// Incrémente la valeur de index de l’instance rmi
		// sans y accéder directement
		index = incrementer.inc();
		Assert.assertEquals(2, index);
		
		// Incrémente la valeur de index de l’instance rmi
		index = rmi.increment();
		Assert.assertEquals(3, index);
	}
}

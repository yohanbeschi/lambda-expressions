package org.isk.references;

import org.isk.references.part1.Point;
import org.isk.references.part1.PointHolder;
import org.isk.references.part1.PointMover;
import org.isk.references.part1.PointReader;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yohan Beschi
 */
public class ReferencesTest {
	/**
	 * Reference method of a static method.
	 */
	@Test
	public void referenceMethod1() {
		final PointReader fromMethod = PointHolder::buildStaticPoint;
		final Point point = fromMethod.getPoint();
		
		Assert.assertEquals(new Point(5, 15), point);
	}

	/**
	 * Reference method of an instance method of a particular object.
	 */
	@Test
	public void referenceMethod2() {
		final PointHolder pointHolder = new PointHolder();
		final PointReader fromMethod = pointHolder::buildPoint;
		final Point point = fromMethod.getPoint();
		
		Assert.assertEquals(new Point(5, 15), point);
	}
	
	//-------------------------------------------------------------
	
	public Point buildPointUsingThis() {
		final PointHolder pointHolder = new PointHolder();
		return pointHolder.point;
	}
	
	/**
	 * Reference method of an instance method of a particular object using 
	 * <code>this</code>.
	 */
	@Test
	public void referenceMethod3() {
		final PointReader fromMethod = this::buildPointUsingThis;
		final Point point = fromMethod.getPoint();
		
		Assert.assertEquals(new Point(10, 20), point);
	}

	/**
	 * Reference constructor.
	 */
	@Test
	public void referenceConstructor() {
		final PointMover fromConstructor = PointHolder::new;
		
		final Point point = new Point(1, 1);
		fromConstructor.movePoint(point);
		
		Assert.assertEquals(new Point(10, 20), point);
	}

}

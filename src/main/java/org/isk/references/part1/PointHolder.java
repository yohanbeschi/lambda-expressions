package org.isk.references.part1;

/**
 * @author Yohan Beschi
 */
public class PointHolder {
	public Point point;
	
	public PointHolder() {
		this.point = new Point();
		point.x = 10;
		point.y = 20;
	}

	public PointHolder(Point point) {
		this();
		point.x = this.point.x;
		point.y = this.point.y;
	}
	
	public Point buildPoint() {
		return new Point(5, 15);
	}

	public static Point buildStaticPoint() {
		return new Point(5, 15);
	}
}

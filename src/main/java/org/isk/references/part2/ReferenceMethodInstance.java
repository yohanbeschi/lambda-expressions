package org.isk.references.part2;

/**
 * @author Yohan Beschi
 */
public class ReferenceMethodInstance {
	private int index;

	public ReferenceMethodInstance() {
		this.index = 0;
	}

	public int increment() {
		return ++this.index;
	}
}

package org.isk.defenders.override;

/**
 * @author Yohan Beschi
 */
public interface Reader {
	char next();
	boolean hasNext();

    default void skip(int i) {
		for (; i > 0 && hasNext(); i--) {
			next();
		}
	}
}

package org.isk.defenders.override;

/**
 * @author Yohan Beschi
 */
public interface Reader {
	char next();
	boolean hasNext();
	
	void skip(int i) default {
		for (; i > 0 && hasNext(); i--) {
			next();
		}
	}
}

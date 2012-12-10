package org.isk.defenders.inheritance;

/**
 * @author Yohan Beschi
 */
public interface Reader {
	int getCounter();
	char[] getString();
	void inc();

    default void skip(int i) {
		for (; i > 0 && hasNext(); i--) {
			next();
		}
	}

    default public char next() {
		char c = this.getString()[this.getCounter()];
		this.inc();
		return c;
	}

    default public boolean hasNext() {
		return this.getString().length > this.getCounter();
	}
}

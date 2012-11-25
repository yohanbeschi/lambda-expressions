package org.isk.defenders.inheritance;

/**
 * @author Yohan Beschi
 */
public interface Reader {
	int getCounter();
	char[] getString();
	void inc();
	
	void skip(int i) default {
		for (; i > 0 && hasNext(); i--) {
			next();
		}
	}
	
	public char next() default {
		char c = this.getString()[this.getCounter()];
		this.inc();
		return c;
	}

	public boolean hasNext() default {
		return this.getString().length > this.getCounter();
	}
}

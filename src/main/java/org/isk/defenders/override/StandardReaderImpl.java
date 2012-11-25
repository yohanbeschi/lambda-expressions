package org.isk.defenders.override;

/**
 * @author Yohan Beschi
 */
public class StandardReaderImpl implements Reader {
	private int counter;
	private char[] string;
	
	public StandardReaderImpl(String string) {
		this.counter = 0;
		this.string = string.toCharArray();
	}

	public char next() {
		return this.string[this.counter++];
	}

	public boolean hasNext() {
		return this.string.length > this.counter;
	}
	
	public void skip(int i) {
		for (; i > 0 && hasNext(); i--) {
			this.next();
		}
	}
}

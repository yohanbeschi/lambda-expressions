package org.isk.defenders.intro;

/**
 * @author Yohan Beschi
 */
public class ReaderImpl implements Reader {
	private int counter;
	private char[] string;
	
	public ReaderImpl(String string) {
		this.counter = 0;
		this.string = string.toCharArray();
	}

	public char next() {
		return this.string[this.counter++];
	}

	public boolean hasNext() {
		return this.string.length > this.counter;
	}
}

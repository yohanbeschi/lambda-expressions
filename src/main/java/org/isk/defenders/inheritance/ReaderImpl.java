package org.isk.defenders.inheritance;

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

	public int getCounter() {
		return this.counter;
	}

    public void inc() {
		this.counter++;
	}

	public char[] getString() {
		return this.string;
	}
}

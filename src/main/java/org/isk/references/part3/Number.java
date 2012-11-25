package org.isk.references.part3;

/**
 * @author Yohan Beschi
 */
public class Number {
	public int num;
	
	public Number(int num) {
		this.num = num;
	}
	
	public int getInt() {
		return this.num;
	}
	
	public int compare(Number numToCompareTo) {
		if (this.num == numToCompareTo.num) {
			return 0;
		} else if (this.num > numToCompareTo.num) {
			return 1;
		} else {
			return -1;
		}
	}
}

package com.audronfs.rocketsci.model;

public class Plateau {

	private int top;
	private int right;
	private final int bottom = 0;
	private final int left = 0;

	public void setCoordinates(int right, int top) {
		this.top = top;
		this.right = right;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getBottom() {
		return bottom;
	}

	public int getLeft() {
		return left;
	}
}
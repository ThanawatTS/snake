package Gamesnake;

import Ui.Desktop;

public class Locate {
	

//	public static final Locate NORTH = new Locate(0, -1);
//	public static final Locate SOUTH = new Locate(0, 1);
//	public static final Locate WEST = new Locate(-1, 0);
//	public static final Locate EAST = new Locate(1, 0);
//
//	
	private Snake snake;
	private final int[] x = new int[Desktop.getAllGrid()];
	private final int[] y = new int[Desktop.getAllGrid()];

	public Locate() {
		this.x[0] = 0;
		this.y[0] = 0;
	}
	public Locate(int x, int y) {
		this.x[0] = x;
		this.y[0] = y;
	}

	public void setX(int x) {
		this.x[0] = x;
	}

	public void setY(int y) {
		this.y[0] = y;
	}

	public int getX() {
		return x[0];
	}

	public int getY() {
		return y[0];
	}
	
//	public void add(Locate locate) {
//		this.x += locate.x;
//		this.y += locate.y;
//	}
	
}

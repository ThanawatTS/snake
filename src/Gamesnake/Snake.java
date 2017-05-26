package Gamesnake;

import Ui.Desktop;

public class Snake implements FatherSnake{
	
	private final int[] x = new int[Desktop.getAllGrid()];
	private final int[] y = new int[Desktop.getAllGrid()];

	private boolean TurnRight=false;
	private boolean TurnLeft=false;
	private boolean TurnUp=false;
	private boolean TurnDown=false;
	private static int SnakeLenght; 
	
	
	public Snake(int a,int b){
		SnakeLenght = 4;
		x[0]=a;
		y[0]=b;
	}
	
	public static int getSnakeLenght() {
		return SnakeLenght;
	}

	public static void setSnakeLenght(int snakeLenght) {
		SnakeLenght = snakeLenght;
	}
	
	public int getSnakeX(int index) {
	    return x[index];
	}

	public int getSnakeY(int index) {
	    return y[index];
	}

	public void setSnakeX(int i) {
	    x[0] = i;
	}

	public void setSnakeY(int i) {
	    y[0] = i;
	}
	
	public boolean isTurnRight() {
		return TurnRight;
	}

	public void setTurnRight(boolean turnRight) {
		this.TurnRight = turnRight;
	}
	public boolean isTurnLeft() {
		return TurnLeft;
	}
	public void setTurnLeft(boolean turnLeft) {
		this.TurnLeft = turnLeft;
	}
	public boolean isTurnUp() {
		return TurnUp;
	}
	public void setTurnUp(boolean turnUp) {
		this.TurnUp = turnUp;
	}
	public boolean isTurnDown() {
		return TurnDown;
	}
	public void setTurnDown(boolean turnDown) {
		this.TurnDown = turnDown;
	}
	public void turnNorth(){
		TurnUp = true;
		TurnDown = false;
		TurnLeft = false;
		TurnRight = false;
	}
	public void turnSouth(){
		TurnUp = false;
		TurnDown = true;
		TurnLeft = false;
		TurnRight = false;
	}
	public void turnEast(){
		TurnUp = false;
		TurnDown = false;
		TurnLeft = false;
		TurnRight = true;
	}
	public void turnWest(){
		TurnUp = false;
		TurnDown = false;
		TurnLeft = true;
		TurnRight = false;
	}
	public void update() {
		move();
	}
	public void move() {
		for (int i = SnakeLenght; i > 0; i--) {
			x[i] = x[(i - 1)];
			y[i] = y[(i - 1)];
		}

		if (TurnLeft) {
			x[0] -= Desktop.getGridSize();
		}

		if (TurnRight) {
			x[0] += Desktop.getGridSize();
		}

		if (TurnDown) {
			y[0] += Desktop.getGridSize();
		}

		if (TurnUp) {
			y[0] -= Desktop.getGridSize();
		}
	}


}

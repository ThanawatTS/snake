package Gamesnake;

import Ui.Desktop;

public class Snaketwo implements FatherSnake{

	
	private final int[] x = new int[Desktop.getAllGrid()];
	private final int[] y = new int[Desktop.getAllGrid()];


	private boolean TurnRight=false;
	private boolean TurnLeft=false;
	private boolean TurnUp=false;
	private boolean TurnDown=false;

	private static int SnakeLenght;
	
	
	public Snaketwo(int a,int b){
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
	
	@Override
	public int getSnakeX(int index) {
		// TODO Auto-generated method stub
		return x[index];
	}

	@Override
	public int getSnakeY(int index) {
		// TODO Auto-generated method stub
		return y[index];
	}

	@Override
	public void setSnakeX(int i) {
		// TODO Auto-generated method stub
		x[0] = i;
	}

	@Override
	public void setSnakeY(int i) {
		// TODO Auto-generated method stub
		y[0] = i;
	}

	@Override
	public boolean isTurnRight() {
		// TODO Auto-generated method stub
		return TurnRight;
	}

	@Override
	public void setTurnRight(boolean turnRight) {
		// TODO Auto-generated method stub
		this.TurnRight = turnRight;
	}

	@Override
	public boolean isTurnLeft() {
		// TODO Auto-generated method stub
		return TurnLeft;
	}

	@Override
	public void setTurnLeft(boolean turnLeft) {
		// TODO Auto-generated method stub
		this.TurnLeft = turnLeft;
	}

	@Override
	public boolean isTurnUp() {
		// TODO Auto-generated method stub
		return TurnUp;
	}

	@Override
	public void setTurnUp(boolean turnUp) {
		// TODO Auto-generated method stub
		this.TurnUp = turnUp;
	}

	@Override
	public boolean isTurnDown() {
		// TODO Auto-generated method stub
		return TurnDown;
	}

	@Override
	public void setTurnDown(boolean turnDown) {
		// TODO Auto-generated method stub
		this.TurnDown = turnDown;
	}

	@Override
	public void turnNorth() {
		// TODO Auto-generated method stub
		TurnUp = true;
		TurnDown = false;
		TurnLeft = false;
		TurnRight = false;
	}

	@Override
	public void turnSouth() {
		// TODO Auto-generated method stub
		TurnUp = false;
		TurnDown = true;
		TurnLeft = false;
		TurnRight = false;
	}

	@Override
	public void turnEast() {
		// TODO Auto-generated method stub
		TurnUp = false;
		TurnDown = false;
		TurnLeft = false;
		TurnRight = true;
	}

	@Override
	public void turnWest() {
		// TODO Auto-generated method stub
		TurnUp = false;
		TurnDown = false;
		TurnLeft = true;
		TurnRight = false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		move();
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
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

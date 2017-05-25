package Gamesnake;


public interface FatherSnake {


	public int getSnakeX(int index);

	public int getSnakeY(int index);

	public void setSnakeX(int i);

	public void setSnakeY(int i);

	public boolean isTurnRight();

	public void setTurnRight(boolean turnRight);

	public boolean isTurnLeft();

	public void setTurnLeft(boolean turnLeft);

	public boolean isTurnUp();

	public void setTurnUp(boolean turnUp);

	public boolean isTurnDown();

	public void setTurnDown(boolean turnDown);

	public void turnNorth();

	public void turnSouth();

	public void turnEast();

	public void turnWest();

	public void update();

	public void move();
	
	}

package Gamesnake;

public class Board {

	private Snake snake;
	private Snaketwo snakeTwo;
	private int Height = 600;
	private int Width = 600;
	public Board(){
		start();
	}
	public void start(){
		snake = new Snake(600/2,600/2);
		snakeTwo = new Snaketwo(150 , 150);
		
	}
	public boolean gameEnd(){
		int snakeX = snake.getSnakeX(0);
		int snakeY = snake.getSnakeY(0);
		return ( snakeX < 15 || snakeY < 15 || snakeX > Width - 30 || snakeY > Height - 30);
	}
	public boolean gameEnd2(){
		int snakeX = snakeTwo.getSnakeX(0);
		int snakeY = snakeTwo.getSnakeY(0);
		return ( snakeX < 15 || snakeY < 15 || snakeX > Width - 30 || snakeY > Height - 30);
	}
	public void update(){
		snake.update();
		snakeTwo.update();
	}
	public Snaketwo getSnakeTwo(){
		return snakeTwo;
	}
	public Snake getSnake(){
		return snake;
	}
	public int getSizeHeight(){
		return Height;
	}
	public int getSIzeWidth(){
		return Width;
	}
	
}

package Gamesnake;

public class Board {

	private Snake snake;
	private Snaketwo snakeTwo;
	private Food food = new Food();
	private Game game ;
	
	private int Height = 600;
	private int Width = 600;
	public Board(){
		start();
	}
	public void start(){
		snake = new Snake(Height/2,Width/2);
		snakeTwo = new Snaketwo(Height/4,Width/4);
		
		
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
	
	public boolean SnakeEnd()
	{
		for(int i=0 ; i<snakeTwo.getSnakeLenght();i++){
			if(snake.getSnakeX(0)==snakeTwo.getSnakeX(i)&&snake.getSnakeY(0)==snakeTwo.getSnakeY(i))
			{
				System.out.println("a"+snakeTwo.getSnakeX(i));
				return true;
			}
			else if(snakeTwo.getSnakeX(0)==snake.getSnakeX(i)&&snakeTwo.getSnakeY(0)==snake.getSnakeY(i))
			{
				System.out.println("a"+snakeTwo.getSnakeX(i));
				return true;
			}
		}
		 return false;
	}
	public void update(){
		snake.update();
		snakeTwo.update();
		for(int i=0 ; i<snakeTwo.getSnakeLenght();i++){
			System.out.println("a"+snakeTwo.getSnakeX(i));
		}
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
	public Food getFood(){
		return food;
	}
	
}

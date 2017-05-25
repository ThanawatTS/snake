package Gamesnake;

import Ui.Desktop;

public class Board {

	private Snake snake;
	private int Height = 600;
	private int Width = 600;
	public Board(){
		start();
	}
	public void start(){
		snake = new Snake(600/2,600/2);
		
	}
	public void update(){
		snake.update();
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

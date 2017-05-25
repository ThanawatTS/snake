package Direction;

import Gamesnake.Snake;

public class North extends Direction{
	
	public North(long timeingame){
		super(timeingame);
	}

	@Override
	public void work(Snake snake) {
		// TODO Auto-generated method stub
		System.out.println("3");
		snake.turnNorth();
		
	}

	

}

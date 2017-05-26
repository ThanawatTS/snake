package Direction;

import Gamesnake.Snake;
import Gamesnake.Snaketwo;

public class North extends Direction{
	
	public North(long timeingame){
		super(timeingame);
	}

	@Override
	public void work(Snake snake) {
		// TODO Auto-generated method stub
		snake.turnNorth();
		
	}

	@Override
	public void workTwo(Snaketwo snake) {
		// TODO Auto-generated method stub
		snake.turnNorth();
	}

	

}

package Direction;

import Gamesnake.Snake;

public class South extends Direction{

	public South(long timeingame) {
		super(timeingame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void work(Snake snake) {
		// TODO Auto-generated method stub
		snake.turnSouth();
	}

}

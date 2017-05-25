package Direction;

import Gamesnake.Snake;

public class West extends Direction{

	public West(long timeingame) {
		super(timeingame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void work(Snake snake) {
		// TODO Auto-generated method stub
		snake.turnWest();
	}

}

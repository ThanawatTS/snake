package Direction;

import Gamesnake.Snake;
import Gamesnake.Snaketwo;

public class East extends Direction{

	public East(long timeingame) {
		super(timeingame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void work(Snake snake) {
		// TODO Auto-generated method stub
		snake.turnEast();
	}

	@Override
	public void workTwo(Snaketwo snake) {
		// TODO Auto-generated method stub
		snake.turnEast();
	}

}

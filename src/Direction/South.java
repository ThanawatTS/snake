package Direction;

import Gamesnake.Snake;
import Gamesnake.Snaketwo;

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

	@Override
	public void workTwo(Snaketwo snake) {
		// TODO Auto-generated method stub
		snake.turnSouth();
	}

}

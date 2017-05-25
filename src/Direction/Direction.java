package Direction;

import Gamesnake.Snake;

public abstract class Direction {

	private long timeingame;
	
	public Direction(long timeingame){
		this.timeingame = timeingame;
	}
	
	public long getTimeInGame(){
		return timeingame;
	}
	public abstract void work(Snake snake);
}

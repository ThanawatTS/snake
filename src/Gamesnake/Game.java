package Gamesnake;

import java.util.ArrayList;
import java.util.List;
import Direction.Direction;
import Direction.East;
import Direction.North;
import Direction.South;
import Direction.West;

public class Game  {

	private Board board;
	private Long timeingame;
	private Long starttime;
	private boolean end;
	
	public static final long DELAY = 25;
	private List<Direction> direction = new ArrayList<Direction>();
	
	public Game(){
		board = new Board();
	}
	public void start(){
		board.start();
		end = false;
		starttime = System.currentTimeMillis();
		while(!end){
			board.update();
			if(board.gameEnd()){
				end = true;
			}
			else if (board.gameEnd2()){
				end = true;
			}
			
			timeingame = System.currentTimeMillis() - starttime;
			delay();
			
		}
	}
	
	public void replay(){
		board.start();
		end = false;
		starttime = System.currentTimeMillis();
		while(!end){
			timeingame = System.currentTimeMillis() - starttime;
			if(!direction.isEmpty()){
				Direction di = direction.get(0);
				Direction di2 = direction.get(0);
				if(timeingame >= di.getTimeInGame()){
					direction.remove(di);
					di.work(board.getSnake());
					di2.workTwo(board.getSnakeTwo());
				}
			}
			board.update();
			if(board.gameEnd()){
				end = true;
			}
			else if (board.gameEnd2()){
				end = true;
			}
			delay();
		}
	}
	
	
	public void turnNorth(){
		System.out.println("1");
		command(new North(timeingame));
		
	}
	public void turnSouth(){
		command(new South(timeingame));
	}
	public void turnEast(){
		command(new East(timeingame));
	}
	public void turnWest(){
		command(new West(timeingame));
	}
	
//--------------------SnakeTwo------------
	public void turnNorthtwo(){
		System.out.println("1");
		commandTwo(new North(timeingame));
		
	}
	public void turnSouthtwo(){
		commandTwo(new South(timeingame));
	}
	public void turnEasttwo(){
		commandTwo(new East(timeingame));
	}
	public void turnWesttwo(){
		commandTwo(new West(timeingame));
	}
	
	public int getSizeHeight(){
		return board.getSizeHeight();
	}
	public int getSizeWidth(){
		return board.getSIzeWidth();
	}
	public boolean End(){
		return end;
	}
	public long getTimegame(){
		return timeingame;
	}
	public int getSnakeLocateX(int i){
		return board.getSnake().getSnakeX(i);
	}
	public int getSnakeLocateY(int i){
		return board.getSnake().getSnakeY(i);
	}
	public int getSnakesize(){
		return board.getSnake().getSnakeLenght();
	}
//--------------SnakeTwo------------
	public int getSnakeTwoLocateX(int i){
		return board.getSnakeTwo().getSnakeX(i);
	}
	public int getSnakeTwoLocateY(int i){
		return board.getSnakeTwo().getSnakeY(i);
	}
	public int getSnakeTwoesize(){
		return board.getSnakeTwo().getSnakeLenght();
	}
	
//	public Locate getSnakeLocate(){
//		return board.getSnake().getLocate();
//	}
//	public int getSnakeLocationX(){
//		return board.getSnake().getLocate().getX();
//	}
//	public int getSnakeLocationY(){
//		return board.getSnake().getLocate().getY();
//	}
	
	private void command(Direction direct){
		System.out.println("2");
		direct.work(board.getSnake());
		direction.add(direct);
		
	}
	private void commandTwo(Direction direct){
		System.out.println("2");
		direct.workTwo(board.getSnakeTwo());
		direction.add(direct);
		
	}
	private void delay(){
		
		try{
			Thread.sleep(DELAY);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		
	}

	
	
}

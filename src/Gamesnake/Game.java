package Gamesnake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

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
	private Timer timer;
	
	public static final long DELAY = 15;
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
			end = board.gameEnd();
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
				if(timeingame >= di.getTimeInGame()){
					direction.remove(di);
					di.work(board.getSnake());
				}
			}
			board.update();
			end = board.gameEnd();
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
	public int getsnankeLocateX(int i){
		return board.getSnake().getSnakeX(i);
	}
	public int getsnankeLocateY(int i){
		return board.getSnake().getSnakeY(i);
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
	public int getSnakesize(){
		return board.getSnake().getSnakeLenght();
	}
	
	private void command(Direction direct){
		System.out.println("2");
		direct.work(board.getSnake());
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

package Gamesnake;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import Direction.Direction;
import Direction.East;
import Direction.North;
import Direction.South;
import Direction.West;
import Ui.Firstpage;

public class Game {

	private Board board;
	private Long timeingame;
	private Long starttime;
	public static final long DELAY = 45;
	private int count = 0;
	private int keepfood = 1;

	private boolean end;

	private Food food = new Food();
	Firstpage fpage = new Firstpage();

	private List<Direction> direction = new ArrayList<Direction>();
	private List<Direction> direction2 = new ArrayList<Direction>();

	public Game() {
		board = new Board();
	}

	public void start() {
		board.start();
		end = false;
		starttime = System.currentTimeMillis();
		while (!end) {
			board.update();
			if (board.gameEnd()) {
				end = true;
				setCount(2);
				JOptionPane.showMessageDialog(null, "Player 2 Win!!!\n Score: " + (getSnakeTwoesize() - 4),
						"The Winner", JOptionPane.INFORMATION_MESSAGE);
				System.out.println(getSnakesize());
			} else if (board.gameEnd2()) {
				end = true;
				setCount(2);
				JOptionPane.showMessageDialog(null, "Player 1 Win!!!\n Score: " + (getSnakesize() - 4), "The Winner",
						JOptionPane.INFORMATION_MESSAGE);
				System.out.println(getSnakesize());
			} else if (board.SnakeEnd1()) {
				end = true;
				JOptionPane.showMessageDialog(null, "Player 2 Win!!!\n Score: " + (getSnakeTwoesize() - 4),
						"The Winner", JOptionPane.INFORMATION_MESSAGE);
				System.out.println(getSnakesize());
			} else if (board.SnakeEnd2()) {
				end = true;
				JOptionPane.showMessageDialog(null, "Player 1 Win!!!\n Score: " + (getSnakesize() - 4), "The Winner",
						JOptionPane.INFORMATION_MESSAGE);
				System.out.println(getSnakesize());
			}
			timeingame = System.currentTimeMillis() - starttime;
			delay();
		}
	}

	public void replay() {
		board.start();
		end = false;
		starttime = System.currentTimeMillis();
		while (!end) {
			timeingame = System.currentTimeMillis() - starttime;

			if (!direction.isEmpty() && direction2.isEmpty()) {
				Direction di = direction.get(0);
				if (timeingame >= di.getTimeInGame()) {
					direction.remove(di);
					di.work(board.getSnake());
				}
			}

			else if (!direction2.isEmpty() && direction.isEmpty()) {
				Direction di2 = direction2.get(0);
				if (timeingame >= di2.getTimeInGame()) {
					direction2.remove(di2);
					di2.workTwo(board.getSnakeTwo());
				}
			}

			else if (!direction.isEmpty() && !direction.isEmpty()) {
				Direction di = direction.get(0);
				Direction di2 = direction2.get(0);
				if (timeingame >= di.getTimeInGame() && timeingame >= di2.getTimeInGame()) {
					direction.remove(di);
					di.work(board.getSnake());
					direction2.remove(di2);
					di2.workTwo(board.getSnakeTwo());
				}
			}
			board.update();
			if (board.gameEnd()) {
				fpage.setVisible(true);
				end = true;
				setCount(2);
			} else if (board.gameEnd2()) {
				fpage.setVisible(true);
				end = true;
				setCount(2);
			} else if (board.SnakeEnd1()) {
				fpage.setVisible(true);
				end = true;
			} else if (board.SnakeEnd2()) {
				fpage.setVisible(true);
				end = true;
			}
			delay();
		}
	}

	public void turnNorth() {

		command(new North(timeingame));

	}

	public void turnSouth() {
		command(new South(timeingame));
	}

	public void turnEast() {
		command(new East(timeingame));
	}

	public void turnWest() {
		command(new West(timeingame));
	}

	// --------------------SnakeTwo------------
	public void turnNorthtwo() {

		commandTwo(new North(timeingame));

	}

	public void turnSouthtwo() {
		commandTwo(new South(timeingame));
	}

	public void turnEasttwo() {
		commandTwo(new East(timeingame));
	}

	public void turnWesttwo() {
		commandTwo(new West(timeingame));
	}

	public int getSizeHeight() {
		return board.getSizeHeight();
	}

	public int getSizeWidth() {
		return board.getSIzeWidth();
	}

	public boolean End() {

		return end;
	}

	public long getTimegame() {
		return timeingame;
	}

	public int getSnakeLocateX(int i) {
		return board.getSnake().getSnakeX(i);
	}

	public int getSnakeLocateY(int i) {
		return board.getSnake().getSnakeY(i);
	}

	public int getSnakesize() {
		return board.getSnake().getSnakeLenght();
	}

	// --------------SnakeTwo------------
	public int getSnakeTwoLocateX(int i) {
		return board.getSnakeTwo().getSnakeX(i);
	}

	public int getSnakeTwoLocateY(int i) {
		return board.getSnakeTwo().getSnakeY(i);
	}

	public int getSnakeTwoesize() {
		return board.getSnakeTwo().getSnakeLenght();
	}

	// =================food===================

	public int getCount() {
		return count;
	}

	public void CreateFood() {
		food.CreateFood();
	}

	public int getKeepfoodx(int index) {
		return food.getKeepfoodx(index);
	}

	public void setKeepfoodx(int index, int X) {
		food.setKeepfoodx(index, X);
	}

	public int getKeepfoody(int index) {
		return food.getKeepfoody(index);
	}

	public void setKeepfoody(int index, int Y) {
		food.setKeepfoody(index, Y);
	}

	public void setFoodx(int foodx) {
		food.setFoodx(foodx);
	}

	public void setFoody(int foody) {
		food.setFoody(foody);
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getFoodX() {
		return food.getFoodx();
	}

	public int getFoodY() {
		return food.getFoody();
	}

	public int getkeepfood() {
		return keepfood;

	}

	public void SnakeEatFood() {

		if (board.getSnake().getSnakeX(0) == getFoodX() && board.getSnake().getSnakeY(0) == getFoodY()) {
			board.getSnake().setSnakeLenght(board.getSnake().getSnakeLenght() + 1);

			if (getCount() == 1) {
				setCount(0);
			} else if (getCount() == 3) {
				setCount(2);

				keepfood++;
			}

		} else if (board.getSnakeTwo().getSnakeX(0) == getFoodX() && board.getSnakeTwo().getSnakeY(0) == getFoodY()) {
			board.getSnakeTwo().setSnakeLenght(board.getSnakeTwo().getSnakeLenght() + 1);
			if (end) {
				setCount(2);
				keepfood++;
			} else if (!end) {
				setCount(0);
			}
			if (getCount() == 1) {
				setCount(0);
			}
		}
	}

	private void command(Direction direct) {
		direct.work(board.getSnake());
		direction.add(direct);

	}

	private void commandTwo(Direction direct) {
		direct.workTwo(board.getSnakeTwo());
		direction2.add(direct);

	}

	private void delay() {

		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

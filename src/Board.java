import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Board extends JPanel{

	public int height = 800;
	public int width = 800;
	private int gridSize = 10;
	private Snake snake = new Snake();
	private Food food = new Food();
	private boolean inGame =true;
	public Board(){
		addKeyListener(new Keys());
		snake.move();
		repaint();
		setPreferredSize(new Dimension(height, width));
		init();
	
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		paintBackground(g);
		paintGrids(g);
		draw(g);
	}

	void draw(Graphics g)
	{
		 g.setColor(Color.blue);
	     g.fillRect(food.getFoodX(), food.getFoodY(), gridSize, gridSize);
	     for (int i = 0; i < snake.getSnakeLenght(); i++) {
	           System.out.println(i);
	            if (i == 0) {
	                g.setColor(Color.RED);
	                g.fillRect(snake.getSnakeX(i), snake.getSnakeY(i),gridSize, gridSize);
	                
	            } else {
	                g.fillRect(snake.getSnakeX(i), snake.getSnakeY(i),gridSize, gridSize);
	            }
	}
	     }
	
	private void paintBackground(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	private void paintGrids(Graphics g) {
		g.setColor(Color.lightGray);
		int gridCountX = getWidth() / gridSize;
		int gridCountY = getHeight() / gridSize;
		for (int i = 0; i < gridCountX; i++) {
			g.drawLine(gridSize * i, 0, gridSize * i, getHeight());
		}
		for (int i = 0; i < gridCountY; i++) {
			g.drawLine(0, gridSize * i, getWidth(), gridSize * i);
		}
	}
	
	
	public void init(){
		 snake.setSnakeLenght(4);
		 for (int i = 0; i < snake.getSnakeLenght(); i++) {
		      snake.setSnakeX(i,(width / 2)-(i*10));
		      snake.setSnakeY(i,(height / 2));
		    }
		 snake.setTurnRight(true);
		 food.createFood();

		
	}
	
	public int getGridSize() {
		return gridSize;
	}

	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}

	
	

	
	private class Keys extends KeyAdapter {
	    @Override
	    public void keyPressed(KeyEvent e) {

	        if ((e.getKeyCode()==37) && (!snake.isTurnRight())) {
	            snake.setTurnLeft(true);
	            snake.setTurnUp(false);
	            snake.setTurnDown(false);
	        }

	        if ((e.getKeyCode()==39) && (!snake.isTurnLeft())) {
	            snake.setTurnRight(true);
	            snake.setTurnUp(false);
	            snake.setTurnDown(false);
	        }

	        if ((e.getKeyCode()==38) && (!snake.isTurnDown())) {
	            snake.setTurnUp(true);
	            snake.setTurnRight(false);
	            snake.setTurnLeft(false);
	        }

	        if ((e.getKeyCode()==40) && (!snake.isTurnUp())) {
	            snake.setTurnDown(true);
	            snake.setTurnRight(false);
	            snake.setTurnLeft(false);
	        }

	        if ((e.getKeyCode() == KeyEvent.VK_ENTER) && (inGame == false)) {

	            inGame = true;
	            snake.setTurnDown(false);
	            snake.setTurnRight(false);
	            snake.setTurnLeft(false);
	            snake.setTurnUp(false);

	            init();
	        }
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

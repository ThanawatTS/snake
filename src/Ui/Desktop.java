package Ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import Gamesnake.Board;
import Gamesnake.Game;
import Gamesnake.Locate;
import Gamesnake.Snake;


public class Desktop extends JFrame implements KeyListener, ActionListener{

	private JPanel main;
	private JButton replaybtn;
	
	private Game game;
	private Timer time;
	private static int speed = 15;
	
	
	private  final static int GridSize = 15;
	private static int AllGrid = (600 * 600) / (GridSize * GridSize);
	private Timer render;
	private int fps = 60;
	
	public Desktop(){
		game = new Game();
		initCompo();
		initControl();
		initRender();
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private void initCompo(){
		setLayout(new BorderLayout());
		
		main = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				draw(g);
			}
		};
		
		main.setPreferredSize(new Dimension(game.getSizeHeight(),game.getSizeWidth()));
		main.setDoubleBuffered(true);
		add(main);
		
		replaybtn = new JButton("Replay");
		replaybtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.print("asas");
				replay();
			}
			
		});
		replaybtn.setEnabled(true);
		add(replaybtn, BorderLayout.SOUTH);
		
	}
	
	private void initRender(){
		render = new Timer(1000/ fps, this);
		ActionListener listener = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.repaint();
					
			}
		};
		
		render.addActionListener(listener);
		render.start();
	}
	private void initControl(){
		this.addKeyListener(this);
		main.addKeyListener(this);
		replaybtn.addKeyListener(this);
	}
	
	private void draw(Graphics g){
		paintBackground(g);
		paintGrids(g);
		drawSnake(g);
	}
	
	private void paintBackground(Graphics g){
		
		g.setColor(Color.orange);
		g.fillRect(0, 0, game.getSizeHeight(),game.getSizeWidth());
	}
	
	private void paintGrids(Graphics g){
		g.setColor(Color.lightGray);
		int gridCountX = getWidth() / GridSize;
		int gridCountY = getHeight() / GridSize;
		for (int i = 0; i < gridCountX; i++) {
			g.drawLine(GridSize * i, 0, GridSize * i, getHeight());
		}
		for (int i = 0; i < gridCountY; i++) {
			g.drawLine(0, GridSize * i, getWidth(), GridSize * i);
		}
	}
	
	private void drawSnake(Graphics g){
		g.setColor(Color.black);
		int snakelength = game.getSnakesize();
		for (int i = 0; i < game.getSnakesize(); i++) {
            if (i == 0) {
                g.fillRect(game.getsnankeLocateX(i), game.getsnankeLocateY(i),GridSize, GridSize);
                
            } else {
                g.fillRect(game.getsnankeLocateX(i), game.getsnankeLocateY(i),GridSize, GridSize);
            }
           
	}
//		snake.setSnakeLenght(4); 
//		   for (int i = 0; i < snake.getSnakeLenght(); i++) {
//			   snake.setSnakeX((Height / 2)-(i*GridSize));
//		       snake.setSnakeY(Width / 2);
//		   }
//		   for (int i = 0; i < snake.getSnakeLenght(); i++) {
//			   if (i == 0) {
//				   g.setColor(Color.black);
//				g.fillRect(snake.getSnakeX(i), snake.getSnakeY(i),GridSize, GridSize);
//
//			   } else {
//				g.fillRect(snake.getSnakeX(i), snake.getSnakeY(i),GridSize, GridSize);
//			   }
//		   }
		
	
	}
	
	
	
	public void start(){
		game.start();
	}
	
	public void replay(){
		SwingWorker sw = new SwingWorker(){
			public Object doInBackground(){
//				game.replay();
					return null;
			}
		};
		sw.execute();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 37){
			System.out.print("west");
			game.turnWest();
		}
		else if (e.getKeyCode() == 39){
			System.out.print("East");
			game.turnEast();
		}
		else if (e.getKeyCode() == 38){
			System.out.println("North");
			game.turnNorth();
		}
		else if (e.getKeyCode() == 40){
			game.turnSouth();
			System.out.print("South");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

	public static int getAllGrid() {
		// TODO Auto-generated method stub
		return AllGrid;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	
	public static int getGridSize() {
		// TODO Auto-generated method stub
		return GridSize;
	}
	
	public static void main(String[] args){
		Desktop desktop = new Desktop();
		desktop.setVisible(true);
		desktop.start();
	}

	
	
}

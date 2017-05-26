package Ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;

import Gamesnake.Game;


public class Desktop extends JFrame implements KeyListener, ActionListener{

	private JPanel main;
	private JButton replaybtn,replaybtn2;

	private Game game;
	private final static int GridSize = 15;
	private static int AllGrid = (600 * 600) / (GridSize * GridSize);
	private Timer render;
	private int fps = 100;
	private int keep=0;
	private boolean Alreadyreplay = true;
	private Image appleIcon = new ImageIcon("/SnakeMenu/src/image/apple.png").getImage();

	public Desktop(){
		game = new Game();
		initCompo();
		initControl();
		initRender();
		setBounds(350, 50, 600, 600);
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

		main.setPreferredSize(new Dimension(game.getSizeWidth(),game.getSizeHeight()));
		main.setDoubleBuffered(true);
		add(main);

		replaybtn = new JButton("Replay");
		replaybtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				replay();
			}

		});
		replaybtn.setBackground(new Color(59, 89, 182));
		replaybtn.setForeground(Color.PINK);
		replaybtn.setFocusPainted(false);
		replaybtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		replaybtn.setEnabled(false);
		add(replaybtn, BorderLayout.SOUTH);
		
	}


	private void initRender(){

		render = new Timer(1000/ fps, this);
		ActionListener listener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.repaint();
				if(game.End()&& Alreadyreplay){
					replaybtn.setEnabled(true);
				}
				else if(game.End()&& Alreadyreplay){
					replaybtn.setEnabled(true);
				}
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
		drawFood(g);
//		paintline(g);
	}

	private void paintBackground(Graphics g){

		g.setColor(Color.orange);
		g.fillRect(0, 0, game.getSizeWidth(),game.getSizeHeight());
	}

//	private void paintline(Graphics g){
//		g.setColor(Color.red);
//		g.fillRect(game.getSizeWidth()/4 + 135, game.getSizeHeight() /2 - 300  , game.getSizeHeight()/4 - 120, game.getSizeHeight());
//	}
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

		for (int i = 0; i < game.getSnakesize(); i++) {
            if (i == 0) {
                g.fillRect(game.getSnakeLocateX(i), game.getSnakeLocateY(i),GridSize, GridSize);

            } else {
                g.fillRect(game.getSnakeLocateX(i), game.getSnakeLocateY(i),GridSize, GridSize);
            }
		}
		
		g.setColor(Color.YELLOW);

		for (int i = 0; i < game.getSnakeTwoesize(); i++) {
            if (i == 0) {
                g.fillRect(game.getSnakeTwoLocateX(i), game.getSnakeTwoLocateY(i),GridSize, GridSize);

            } else {
                g.fillRect(game.getSnakeTwoLocateX(i), game.getSnakeTwoLocateY(i),GridSize, GridSize);
            }
		}
	}


	private void drawFood(Graphics g){
		g.setColor(Color.green);
		int x=0;
		int y=0;
		if(game.getCount()==0){
		game.CreateFood();
		game.setCount(1);
		keep++;
		
		}

		else if(game.getCount()==2)
		{
		
		game.setFoodx(game.getKeepfoodx(game.getkeepfood()));
		game.setFoody(game.getKeepfoody(game.getkeepfood()));
		game.setCount(3);
		}

		x = game.getFoodX();
		y = game.getFoodY();
		game.setKeepfoodx(keep, x);
		game.setKeepfoody(keep, y);

		   g.fillRect(x, y, GridSize, GridSize);
		}

	public void start(){
		game.start();
	}

	public void replay(){
		replaybtn.setEnabled(false);
		Alreadyreplay = false;
		SwingWorker sw = new SwingWorker(){
			public Object doInBackground(){
				game.replay();
					return null;
			}
		};
		sw.execute();
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 37){
			game.turnWest();
		}
		else if (e.getKeyCode() == 39){
			game.turnEast();
		}
		else if (e.getKeyCode() == 38){
			game.turnNorth();
		}
		else if (e.getKeyCode() == 40){
			game.turnSouth();
		}

//------------------------------------------//
		if(e.getKeyCode() == 65){
			game.turnWesttwo();
		}
		else if (e.getKeyCode() == 68){
			game.turnEasttwo();
		}
		else if (e.getKeyCode() == 87){

			game.turnNorthtwo();
		}
		else if (e.getKeyCode() == 83){
			game.turnSouthtwo();
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
		game.SnakeEatFood();

	}

	public static int getGridSize() {
		// TODO Auto-generated method stub
		return GridSize;
	}

	public static void main(String[] args){
		
		
		Desktop desktop = new Desktop();
		desktop.setVisible(true);
		ImageIcon img = new ImageIcon("src/Image/apple.png");
		desktop.setIconImage(img.getImage());
		desktop.setTitle("Snake");
		try{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
		}
		catch (Exception ex){
			
		}
		desktop.start();
	}



}

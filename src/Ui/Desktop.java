package Ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Game.Game;


public class Desktop extends JFrame {

	private JPanel main;
	private JButton replaybtn;
	
	private Game game;
	
	private  final static int Width = 600;
	private  final static int Height = 600;
	private  final static int GridSize = 15;
	

	public Desktop(){
		game = new Game();
		initCompo();
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
		
		
		main.setPreferredSize(new Dimension(Width,Height));
		main.setDoubleBuffered(true);
		add(main);
		
		replaybtn = new JButton("Replay");
		replaybtn.setEnabled(false);
		add(replaybtn, BorderLayout.SOUTH);
	}
	
	private void draw(Graphics g){
		paintBackground(g);
		paintGrids(g);
	}
	
	private void paintBackground(Graphics g){
		g.setColor(Color.orange);
		g.fillRect(0, 0, Width,Height);
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
	
	public void start(){
		
	}
	
	public static void main(String[] args){
		Desktop desktop = new Desktop();
		desktop.setVisible(true);
		desktop.start();
	}
	
	
	
}

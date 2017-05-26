package Ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Firstpage extends JFrame {
	
	Image img;
	JButton b1;
	JLabel l1;
	
	public Firstpage(){
		 	setLayout(new BorderLayout());
		    setContentPane(new JLabel(new ImageIcon("src/Image/Snakepage3.png")));
		    setLayout(new FlowLayout());
		    l1=new JLabel("Here is a button");
		    b1=new JButton("I am a button");
		   
		    
		    pack();
	}
	
	
	
	
	public static void main(String[] args){
		Firstpage fpage = new Firstpage();
		fpage.setVisible(true);
		
	}
}

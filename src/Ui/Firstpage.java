package Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Firstpage extends JFrame implements KeyListener {

	Image img;

	public Firstpage() {

		setContentPane(new JLabel(new ImageIcon("src/Image/Snakepage3.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 50, 617, 632);
		getContentPane().setLayout(null);

		JButton Entergame = new JButton("Spacebar for exit");
		Entergame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});
		Entergame.setBackground(Color.GRAY);
		Entergame.setForeground(Color.PINK);
		Entergame.setFont(new Font("Tahoma", Font.BOLD, 20));

		Entergame.setBounds(160, 350, 250, 50);
		getContentPane().add(Entergame);

		this.addKeyListener(this);
		Entergame.addKeyListener(this);

	}

	public static void main(String[] args) {
		Firstpage fpage = new Firstpage();
		fpage.setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 32) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}

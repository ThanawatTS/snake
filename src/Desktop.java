import java.awt.*;

import javax.swing.*;

public class Desktop extends JFrame{

	private JPanel title = new JPanel();
	private Board boardcreate = new Board();
	
	public Desktop(){
		super("Snake Board Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		pack();
	}
	
	public void initComponents(){
		setLayout(new BorderLayout());
		add(boardcreate);
		
		title.setLayout(new FlowLayout());
		add(title, BorderLayout.NORTH);
		title.add(new JLabel("SNAKE"));
		
	}
	
	public static void main(String[] args){
		Desktop desktop = new Desktop();
		desktop.setVisible(true);
	}
	
}

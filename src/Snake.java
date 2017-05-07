
public class Snake {
	private final int[] x = new int[800];
	private final int[] y = new int[800];
	private boolean TurnRight=false;
	private boolean TurnLeft=false;
	private boolean TurnUp=false;
	private boolean TurnDown=false;
	private int SnakeLenght=0;
	private Board board;
	
	public int getSnakeLenght() {
		return SnakeLenght;
	}

	public void setSnakeLenght(int snakeLenght) {
		SnakeLenght = snakeLenght;
	}

	public boolean isTurnRight() {
		return TurnRight;
	}
	
	public void setTurnRight(boolean turnRight) {
		this.TurnRight = turnRight;
	}
	public boolean isTurnLeft() {
		return TurnLeft;
	}
	public void setTurnLeft(boolean turnLeft) {
		this.TurnLeft = turnLeft;
	}
	public boolean isTurnUp() {
		return TurnUp;
	}
	public void setTurnUp(boolean turnUp) {
		this.TurnUp = turnUp;
	}
	public boolean isTurnDown() {
		return TurnDown;
	}
	public void setTurnDown(boolean turnDown) {
		this.TurnDown = turnDown;
	}
	public int getSnakeX(int index) {
	    return x[index];
	}

	public int getSnakeY(int index) {
	    return y[index];
	}

	public void setSnakeX(int i,int num) {
	    x[i] = num;
	}

	public void setSnakeY(int i, int num) {
	    y[i] = num;
	}
	
	public void move() {
	    for (int i = SnakeLenght; i > 0; i--) {
	        x[i] = x[(i - 1)];
	        y[i] = y[(i - 1)];
	    }

	    if (TurnLeft) {
	        x[0] -= board.getGridSize();
	    }
	 
	    if (TurnRight) {
	        x[0] += board.getGridSize();
	    }
	    
	    if (TurnDown) {
	        y[0] += board.getGridSize();
	    }
	  
	    if (TurnUp) {
	        y[0] -= board.getGridSize();
	    }

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

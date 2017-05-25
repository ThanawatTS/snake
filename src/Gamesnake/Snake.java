package Gamesnake;

import Ui.Desktop;

public class Snake implements FatherSnake{
	
	private final int[] x = new int[Desktop.getAllGrid()];
	private final int[] y = new int[Desktop.getAllGrid()];

	// Stores direction of our snake
	private boolean TurnRight=false;
	private boolean TurnLeft=false;
	private boolean TurnUp=false;
	private boolean TurnDown=false;

	private static int SnakeLenght = 0; // Stores # of dots / joints the snake has (starts
	                        // with 3)
	
	
	public Snake(int a,int b){
		SnakeLenght = 4;
		x[0]=a;
		y[0]=b;
	}
	
	public static int getSnakeLenght() {
		return SnakeLenght;
	}

	public static void setSnakeLenght(int snakeLenght) {
		SnakeLenght = snakeLenght;
	}
	
	public int getSnakeX(int index) {
	    return x[index];
	}

	public int getSnakeY(int index) {
	    return y[index];
	}

	public void setSnakeX(int i) {
	    x[0] = i;
	}

	public void setSnakeY(int i) {
	    y[0] = i;
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
	public void turnNorth(){
		TurnUp = true;
		TurnDown = false;
		TurnLeft = false;
		TurnRight = false;
	}
	public void turnSouth(){
		TurnUp = false;
		TurnDown = true;
		TurnLeft = false;
		TurnRight = false;
	}
	public void turnEast(){
		TurnUp = false;
		TurnDown = false;
		TurnLeft = false;
		TurnRight = true;
	}
	public void turnWest(){
		TurnUp = false;
		TurnDown = false;
		TurnLeft = true;
		TurnRight = false;
	}
	public void update() {
		move();
	}
	public void move() {
		for (int i = SnakeLenght; i > 0; i--) {
			x[i] = x[(i - 1)];
			y[i] = y[(i - 1)];
		}

		if (TurnLeft) {
			x[0] -= Desktop.getGridSize();
		}

		if (TurnRight) {
			x[0] += Desktop.getGridSize();
		}

		if (TurnDown) {
			y[0] += Desktop.getGridSize();
		}

		if (TurnUp) {
			y[0] -= Desktop.getGridSize();
		}
	}


}
//
//import Ui.Desktop;
//
//public class Snake {
//
//	private static int SnakeLength = 2;
//	private final static int[] snakeX = new int[Desktop.getAllGrid()];
//	private final static int[] snakeY = new int[Desktop.getAllGrid()];
//	
//	private Locate locate;
//	private Locate velo;
//	private int size;
//	
//	private boolean TurnRight=false;
//	private boolean TurnLeft=false;
//	private boolean TurnUp=false;
//	private boolean TurnDown=false;
//	
//	public static int getSnakeLength(){
//		return SnakeLength;
//	}
//	
//	public static void setSnakeLength(int snakelength){
//		SnakeLength = snakelength;
//	}
//	public int getSnakeX(int index){
//		return snakeX[index];
//	}
//	public int getSnakeY(int index){
//		return snakeY[index];
//	}
//	public static void setSnakeX(int i){
//		snakeX[0] = i;
//	}
//	public static void setSnakeY(int i){
//		snakeY[0] = i;
//	}
//	public Snake(int x,int y){
//		this.snakeX[0] = x;
//		this.snakeY[0] = y;
//		
//	}
//	public boolean isTurnRight() {
//		return TurnRight;
//	}
//	
//	public void setTurnRight(boolean turnRight) {
//		this.TurnRight = turnRight;
//	}
//	public boolean isTurnLeft() {
//		return TurnLeft;
//	}
//	public void setTurnLeft(boolean turnLeft) {
//		this.TurnLeft = turnLeft;
//	}
//	public boolean isTurnUp() {
//		return TurnUp;
//	}
//	public void setTurnUp(boolean turnUp) {
//		this.TurnUp = turnUp;
//	}
//	public boolean isTurnDown() {
//		return TurnDown;
//	}
//	public void setTurnDown(boolean turnDown) {
//		this.TurnDown = turnDown;
//	}
//	public void turnNorth(){
//		TurnUp = true;
//		TurnDown = false;
//		TurnLeft = false;
//		TurnRight = false;
//	}
//	public void turnSouth(){
//		TurnUp = false;
//		TurnDown = true;
//		TurnLeft = false;
//		TurnRight = false;
//	}
//	public void turnEast(){
//		TurnUp = false;
//		TurnDown = false;
//		TurnLeft = true;
//		TurnRight = false;
//	}
//	public void turnWest(){
//		TurnUp = false;
//		TurnDown = false;
//		TurnLeft = false;
//		TurnRight = true;
//	}
//	public void update(){
//		//move();
//	}
//	public void move(){
//		
//		for (int i = getSnakeLength(); i > 0; i--) {
//			snakeX[i] = snakeX[(i - 1)];
//			snakeY[i] = snakeY[(i - 1)];
//	    }
//		if (isTurnUp()){
//			snakeY[0] -= Desktop.getGridSize(); 
//		}
//		if(isTurnDown()){
//			snakeY[0] += Desktop.getGridSize();
//		}
//		if(isTurnLeft()){
//			snakeX[0] -= Desktop.getGridSize();
//		}
//		if(isTurnRight()){
//			snakeX[0] += Desktop.getGridSize();
//		}
//		
//	}
//	
//	public Snake(Locate located){
//		this.locate = located;
//		this.velo = new Locate();
//		size = Desktop.getGridSize()*2;
//	}
//	public Locate getLocate(){
//		return locate;
//	}
//	public Locate getVelo(){
//		return velo;
//	}
//	public int getSize(){
//		return size;
//	}
//	public void turnNorth(){
//		velo = Locate.NORTH;
//	}
//	public void turnSouth(){
//		velo = Locate.SOUTH;
//	}
//	public void turnEast(){
//		velo = Locate.EAST;
//	}
//	public void turnWest(){
//		velo = Locate.WEST;
//	}
//	public void update(){
//		move();
//	}
//	public void move(){
//		locate.add(velo);
//	}
//	---------------
//	public static void setSnakeLength(int snakeLenght){
//		SnakeLenght = snakeLenght;
//	}
//	public int getSnakeLength(){
//		return SnakeLenght;
//	}
//	public int getSnakeLenght(){
//		return SnakeLenght;
//	}
//	public static void setSnakeLenght(int snakeLenght) {
//		SnakeLenght = snakeLenght;
//	}
//	
//	public int getSnakeX(int index) {
//	    return x[index];
//	}
//
//	public int getSnakeY(int index) {
//	    return y[index];
//	}
//
//	public void setSnakeX(int i) {
//	    x[0] = i;
//	}
//
//	public void setSnakeY(int i) {
//	    y[0] = i;
//	}
//	
//	public void checkhead(){
//		
//	}
//	public void turnNorth(){
//		TurnUp = true;
//		TurnDown = false;
//		TurnRight = false;
//		TurnLeft = false;
//		
//	}
//	public void turnSouth(){
//		TurnUp = false;
//		TurnDown = true;
//		TurnRight = false;
//		TurnLeft = false;
//	}
//	public void turnEast(){
//		TurnUp = false;
//		TurnDown = false;
//		TurnRight = true;
//		TurnLeft = false;
//		
//	}
//	public void turnWest(){
//		TurnUp = false;
//		TurnDown = false;
//		TurnRight = false;
//		TurnLeft = true;
//		
//	}
//
//	
//	public void update(){
//		move();
//	}
//	public void move(){
//		 for (int i = SnakeLenght; i > 0; i--) {
//		        x[i] = x[(i - 1)];
//		        y[i] = y[(i - 1)];
//		 }
//	
//		 if(TurnUp){
//			 y[0] -= Desktop.getGridSize();
//		 }
//		 if(TurnDown){
//			 y[0] += Desktop.getGridSize();
//		 }
//		 if(TurnRight){
//			 x[0] += Desktop.getGridSize();
//		 }
//		 if(TurnLeft){
//			 x[0] -= Desktop.getGridSize();
//		 }
//		 
//	}
	
//}

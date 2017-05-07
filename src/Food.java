import java.util.*;
import java.lang.*; 
public class Food {
	private int foodX;
	private int foodY;
	private Board board;
	public void createFood(){
		int location;
		Random random = new Random();
		int randomNumber = random.nextInt(70);
		foodX = randomNumber*10;
		System.out.println(foodX);
		randomNumber = random.nextInt(70);
		foodY = randomNumber*10;
		System.out.println(foodY);
		
	}
	public int getFoodX() {
		return foodX;
	}
	public void setFoodX(int foodX) {
		this.foodX = foodX;
	}
	public int getFoodY() {
		return foodY;
	}
	public void setFoodY(int foodY) {
		this.foodY = foodY;
	}
	
	
	
	
	
	
	
	
	
	
}

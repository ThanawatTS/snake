package Gamesnake;
import java.util.Random;

public class Food {

	private int foodx;
	private int foody;

	public Food()
	{}
	public Food(int x ,int y)
	{
		foodx=0;
		foody=0;
	}
	
	public int getFoodx() {
		return foodx;
	}


	public void setFoodx(int foodx) {
		this.foodx = foodx;
	}


	public int getFoody() {
		return foody;
	}


	public void setFoody(int foody) {
		this.foody = foody;
	}


	public void CreateFood(){
		foodx = RandomFoodLocation();
		foody = RandomFoodLocation();

	}
	
	public int RandomFoodLocation()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(40);
		return randomNumber*15;
	}
	
	
	
	
	
	
	
	
	
	
	
}

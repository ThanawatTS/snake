package Gamesnake;
import java.util.Random;

public class Food {

	private int foodx;
	private int foody;
	
	private int[] keepfoodx = new int[20];
	private int[] keepfoody = new int[20];
	
	
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
	
	public int getKeepfoodx(int index) {
		return keepfoodx[index];
	}
	public void setKeepfoodx(int index,int X) {
		keepfoodx[index] = X;
	}
	
	public int getKeepfoody(int index) {
		return keepfoody[index];
	}
	public void setKeepfoody(int index,int Y) {
		keepfoody[index] = Y;
	}
	
	
	
	
	
	
	
	
	
}

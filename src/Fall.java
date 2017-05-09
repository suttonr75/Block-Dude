
public class Fall {
	private int x;
	private int y;
	private int fallHeight;
	
	Fall(int xCoord, int yCoord, int height){
		x = xCoord;
		y = yCoord;
		fallHeight = height;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getHeight(){
		return fallHeight;
	}
	public void move(){
		y++;
		fallHeight--;
	}

}

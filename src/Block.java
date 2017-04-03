
public class Block {
	private boolean fixed;
	private boolean empty;
	private boolean movable;
	
	public boolean getMovable(){
		return movable;
	}
	
	public void setMovable(boolean m){
		movable = m;
	}
	
	public boolean getEmpty(){
		return empty;
	}
	
	public void setEmpty(boolean e){
		empty = e;
	}
	
	public boolean getFixed(){
		return fixed;
	}
	
	public void setFixed(boolean f){
		fixed = f;
	}

}

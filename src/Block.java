
public class Block {
	private boolean fixed = false;
	private boolean empty = false;
	private boolean movable = false;
	private boolean dude = false;
	private boolean end = false;
	private boolean start = false;
	
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
	
	public boolean getDude(){
		return dude;
	}
	
	public void setDude(boolean d){
		dude = d;
	}
	
	public boolean getEnd(){
		return end;
	}
	
	public void setEnd(boolean e){
		end = e;
	}
	
	public boolean getStart(){
		return start;
	}
	
	public void setStart(boolean s){
		start = s;
	}
	public String toString(){
		String s = "Move: " + movable;
		s += "\t Dude: " + dude;
		return s;
	}

}

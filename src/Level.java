
public class Level {
	private Block[][] board;
	private int dudeX = 0;
	private int dudeY = 0;
	private int dudeRX = 0;
	private int dudeRY = 0;
	private boolean gameOver = false;
	private int blockX = 0;
	private int blockY = 0;
	private boolean blockHeld = false;
	

	
	Level(int width, int height){
		board = new Block[width][height];
		//findDude();
		dudeRX = dudeX;
		dudeRY = dudeY;
	}
	
	public void importCreatedLevel(Block[][] b){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				board[i][j] = b[i][j];
			}
		}
		findDude();
		dudeRX = dudeX;
		dudeRY = dudeY;
	}
	
	public void findDude(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j].getDude()){
					dudeX = i;
					dudeY = j;
				}
			}
		}
	}
	
	public void moveDude(int x, int y){
		if(board[dudeX + x][dudeY + y].getEmpty()){
			board[dudeX][dudeY].setDude(false);
			board[dudeX + x][dudeY + y].setDude(true);
			dudeX += x;
			dudeY += y;
			if(blockHeld){
				moveBlock(x,y);
			}
		}
		checkEnd();

	}
	
	public void moveBlock(int x, int y){
		board[blockX][blockY].setMovable(false);
		board[blockX + x][blockY + y].setMovable(true);
		blockX += x;
		blockY += y;
	}
	
	public void dropBlock(int x, int y){
		board[blockX][blockY].setMovable(false);
		board[x][y].setMovable(true);
		blockHeld = false;
	}
	
	public void pickUpBlock(int x, int y){
		blockHeld = true;
		board[x][y].setMovable(false);
		board[dudeX][dudeY-1].setMovable(true);
		blockX = dudeX;
		blockY = dudeY-1;
	}
	
	public void checkEnd(){
		if(board[dudeX][dudeY].getEnd()){
			gameOver = true;
		}
	}
	
	public void resetDude(){
		board[dudeX][dudeY].setDude(false);
		dudeX = dudeRX;
		dudeY = dudeRY;
		board[dudeX][dudeY].setDude(true);
	}
	
	public String toString(){
		String s = "";
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				s +="(" + i + "," + j + ") :" + board[i][j].toString();
					
			}
		}
		return s;
	}

}

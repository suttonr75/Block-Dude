
public class Level {
	private boolean left = true;
	private Block[][] board;
	private int dudeX = 0;
	private int dudeY = 0;
	private int dudeRX = 0;
	private int dudeRY = 0;
	private boolean gameOver = false;
	private int blockX = 0;
	private int blockY = 0;
	private boolean blockHeld = false;
	public final int width;
	public final int height;



	Level(int w, int h){
		board = new Block[w][h];
		//findDude();
		dudeRX = dudeX;
		dudeRY = dudeY;
		width = w;
		height = h;
	}

	public Block getBlock(int x, int y){
		return board[x][y];
	}

	public boolean getEnd(){
		return gameOver;
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
	public boolean getLeft(){
		return left;
	}
	public void setLeft(boolean l){
		left = l;
	}
	public void moveDude(int x, int y){
		if(dudeX + x < board.length && dudeX + x > -1 && dudeY + y < board[0].length && dudeY + y > -1 ){
	
			if(board[dudeX + x][dudeY + y].getEmpty()||board[dudeX + x][dudeY + y].getEnd()){

				if(blockHeld){
					if(board[blockX + x][blockY + y].getEmpty()){
						board[dudeX][dudeY].setDude(false);
						board[dudeX][dudeY].setEmpty(true);
						board[dudeX + x][dudeY + y].setDude(true);
						dudeX += x;
						dudeY += y;
						
						board[blockX][blockY].setMovable(false);
						board[blockX][blockY].setEmpty(true);
						board[blockX + x][blockY + y].setMovable(true);
						blockX += x;
						blockY += y;
					}

				}else{
					board[dudeX][dudeY].setDude(false);
					board[dudeX][dudeY].setEmpty(true);
					board[dudeX + x][dudeY + y].setDude(true);
					dudeX += x;
					dudeY += y;
				}
			}
			checkEnd();
		}
	}
	public boolean getBlockHeld(){
		return blockHeld;
	}
	public void moveBlock(int x, int y, boolean pickUP){
		if(pickUP){
			if(left){
				blockX = dudeX-1;
				blockY = dudeY;
			}
			else{
				blockX = dudeX+1;
				blockY = dudeY;
			}
			blockHeld = true;
		}
		else{
			blockX = dudeX;
			blockY = dudeY-1;
			blockHeld = false;
		}
		

		board[blockX][blockY].setMovable(false);
		board[blockX][blockY].setEmpty(true);
		board[blockX + x][blockY + y].setMovable(true);
		board[blockX + x][blockY + y].setEmpty(false);
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

	public int getDudeX(){
		return dudeX;
	}

	public int getDudeY(){
		return dudeY;
	}


}

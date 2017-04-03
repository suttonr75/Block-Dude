
public abstract class Level {
	private Block[][] board;
	private int dudeX = 0;
	private int dudeY = 0;
	private boolean gameOver = false;
	
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
		}
		checkEnd();

	}
	
	public void checkEnd(){
		if(board[dudeX][dudeY].getEnd()){
			gameOver = true;
		}
	}

}

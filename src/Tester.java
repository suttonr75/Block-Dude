
public class Tester {
	public static void main(String[] args){
		test1();
	}

	private static void test1() {
		Block[][] board = new Block[10][10];
		for(int i =0;i<10;i++){
			for(int j=0;j<10;j++){
				Block b = new Block();
				board[i][j] = b;
			}
		}
		board[0][0].setEmpty(true);
		board[0][1].setEmpty(true);
		board[0][2].setEmpty(true);
		board[0][3].setEmpty(true);
		board[0][4].setEmpty(true);
		board[0][5].setEmpty(true);
		board[0][6].setEmpty(true);
		board[0][7].setEmpty(true);
		board[0][8].setEnd(true);
		board[0][9].setFixed(true);
		board[1][0].setEmpty(true);
		board[1][1].setEmpty(true);
		board[1][2].setEmpty(true);
		board[1][3].setEmpty(true);
		board[1][4].setEmpty(true);
		board[1][5].setEmpty(true);
		board[1][6].setEmpty(true);
		board[1][7].setEmpty(true);
		board[1][8].setEmpty(true);
		board[1][9].setFixed(true);
		board[2][0].setEmpty(true);
		board[2][1].setEmpty(true);
		board[2][2].setEmpty(true);
		board[2][3].setEmpty(true);
		board[2][4].setEmpty(true);
		board[2][5].setEmpty(true);
		board[2][6].setEmpty(true);
		board[2][7].setEmpty(true);
		board[2][8].setEmpty(true);
		board[2][9].setFixed(true);
		board[3][0].setEmpty(true);
		board[3][1].setEmpty(true);
		board[3][2].setEmpty(true);
		board[3][3].setEmpty(true);
		board[3][4].setEmpty(true);
		board[3][5].setEmpty(true);
		board[3][6].setEmpty(true);
		board[3][7].setEmpty(true);
		board[3][8].setEmpty(true);
		board[3][9].setFixed(true);
		board[4][0].setEmpty(true);
		board[4][1].setEmpty(true);
		board[4][2].setEmpty(true);
		board[4][3].setEmpty(true);
		board[4][4].setEmpty(true);
		board[4][5].setEmpty(true);
		board[4][6].setEmpty(true);
		board[4][7].setEmpty(true);
		board[4][8].setEmpty(true);
		board[4][9].setFixed(true);
		board[5][0].setEmpty(true);
		board[5][1].setEmpty(true);
		board[5][2].setEmpty(true);
		board[5][3].setEmpty(true);
		board[5][4].setEmpty(true);
		board[5][5].setEmpty(true);
		board[5][6].setEmpty(true);
		board[5][7].setEmpty(true);
		board[5][8].setEmpty(true);
		board[5][9].setFixed(true);
		board[6][0].setEmpty(true);
		board[6][1].setEmpty(true);
		board[6][2].setEmpty(true);
		board[6][3].setEmpty(true);
		board[6][4].setEmpty(true);
		board[6][5].setEmpty(true);
		board[6][6].setEmpty(true);
		board[6][7].setEmpty(true);
		board[6][8].setEmpty(true);
		board[6][9].setFixed(true);
		board[7][0].setEmpty(true);
		board[7][1].setEmpty(true);
		board[7][2].setEmpty(true);
		board[7][3].setEmpty(true);
		board[7][4].setEmpty(true);
		board[7][5].setEmpty(true);
		board[7][6].setEmpty(true);
		board[7][7].setEmpty(true);
		board[7][8].setDude(true);
		board[7][9].setFixed(true);
		board[8][0].setEmpty(true);
		board[8][1].setEmpty(true);
		board[8][2].setEmpty(true);
		board[8][3].setEmpty(true);
		board[8][4].setEmpty(true);
		board[8][5].setEmpty(true);
		board[8][6].setEmpty(true);
		board[8][7].setEmpty(true);
		board[8][8].setEmpty(true);
		board[8][9].setFixed(true);
		board[9][0].setEmpty(true);
		board[9][1].setEmpty(true);
		board[9][2].setEmpty(true);
		board[9][3].setEmpty(true);
		board[9][4].setEmpty(true);
		board[9][5].setEmpty(true);
		board[9][6].setEmpty(true);
		board[9][7].setMovable(true);
		board[9][8].setMovable(true);
		board[9][9].setFixed(true);
		Level l = new Level(10, 10);
		l.importCreatedLevel(board);
		GUI g = new GUI(l);
		
	}
}

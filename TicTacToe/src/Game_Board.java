
public class Game_Board {
	final int ROW = 3;	//number of rows
	final int COL = 3;	//number of cols
	char [][] board = new char[ROW][COL];	//board
	private int moveCounter = 0;	//counts game moves
	
	public Game_Board () {
		//initialize board with ' ' 
		for (int row = 0; row < ROW; row++) {
			for (int col = 0; col < COL; col++) {
				board[row][col] = ' ';
			} //end inner for
		}//end outer for
	}//end constructor
	
	public void printBoard() {
		for (int row = 0; row < ROW; row++) {
			System.out.println(board[row][0] + "|" + board[row][1] + "|" + board[row][2]);
			if (row < 2 )
				System.out.println("-----");
		}//end for
	}//end printBoard
	public void moveIncrement() {
		moveCounter += 1;
	}
	public int getMoveCounter () {
		return moveCounter;
	}
	public boolean draw() { 	
		if (moveCounter == 9) {	//max moves on a board = 9
			System.out.println("Cats Game!");
			printBoard();
			return true;
		}
		else {
			return false;
		}
	}
	public boolean winByRow(int player) 
	{ 
	    for (int i=0; i < 3; i++) { 
	        if (board[i][0] == board[i][1] && 
	            board[i][1] == board[i][2] &&  
	            board[i][0] != ' ') {
	        	if (player == 1) {
					System.out.println("X player wins!");
					printBoard();
		        	return true;
				}
				else {
					System.out.println("O player wins!");
					printBoard();
		        	return true;
				}
	        }
	    } 
	    return false; 
	}
	public boolean winByColumn(int player) 
	{
	    for (int i = 0; i < 3; i++) { 
	        if (board[0][i] == board[1][i] && 
	            board[1][i] == board[2][i] &&  
	            board[0][i] != ' ') {
	        	if (player == 1) {
					System.out.println("X player wins!");
					printBoard();
		        	return true;
				}
				else {
					System.out.println("O player wins!");
					printBoard();
		        	return true;
				}
	        }
	    }
	    return false; 
	}
	
	public boolean winByDiagonal(int player) {
		if (board[0][0] == board[1][1] && 
		    board[1][1] == board[2][2] &&  
		    board[0][0] != ' ') {
			if (player == 1) {
				System.out.println("X player wins!");
				printBoard();
	        	return true;
			}
			else {
				System.out.println("O player wins!");
				printBoard();
	        	return true;
			}
		}
		if (board[0][2] == board[1][1] && 
		    board[1][1] == board[2][0] && 
		    board[0][2] != ' ') {
			if (player == 1) {
				System.out.println("X player wins!");
				printBoard();
	        	return true;
			}
			else {
				System.out.println("O player wins!");
				printBoard();
	        	return true;
			}
		}
		return false; 
	}
	//set board with player move
	public void setBoard(int r, int c, int p) {
		if (p == 1) {
			board[r][c] = 'X';
		}
		if (p == 2) {
			board[r][c] = 'O';
		}
	}
	//check if legal move
	boolean legalMove (int r, int c) {
		if (r > 2 && c > 2) {
			System.out.println("Invalid Row & Column Input - Choose 0,1, or 2");
			return false;
		} else if (r > 2 ) {
			System.out.println("Invalid Row Input - Choose 0,1, or 2");
			return false;
		} else if (c > 2) {
			System.out.println("Invalid Column Input - Choose 0,1, or 2");
			return false;
		}
		if (board[r][c] != ' ') {
			System.out.println("Illegal Move");
			return false;
		} else {
			return true;
		}
	}
}//end Game_Board

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
	
		Game_Board game = new Game_Board();		//new game
		Scanner input = new Scanner (System.in); // Creates new Scanner to read input
		int p1r,p1c,p2r,p2c;
		boolean isOver = false;	//set to true when game over
		
		//print game title
		System.out.println("Welcome to Tic-Tac-Toe");
		System.out.println("======================");
		
		//do loop while game is not over
		do {
			//do until user chooses valid input
			//ie. invalid input = position already taken
			do {			
				System.out.println("Player 1 turn 'X'");
				game.printBoard();
				System.out.println("Which Row would you like?");
					p1r = input.nextInt();
				System.out.println("Which Col would you like?");
					p1c = input.nextInt();
			} while (game.legalMove(p1r, p1c) != true);
			
			//after getting valid input, place move on board, and increment move value
			game.setBoard(p1r,p1c, 1);
			game.moveIncrement();
			
			//check if win, or draw
			//If there are less than 5 moves, skip win / draw checks
			if (game.getMoveCounter() >= 4) {
				if (game.winByColumn(1) == true) {
					isOver = true;
				} else if (game.winByDiagonal(1) == true) {
					isOver = true;
				} else if (game.winByRow(1) == true) {
					isOver = true;
				} else if (game.draw() == true) {
					isOver = true;
				}
			}
			
			//if game is already over, skip player 2
			if (isOver != true) {	
				//do until user chooses valid input
				do {
					System.out.println("Player 2 turn 'O'");
					game.printBoard();
					System.out.println("Which Row would you like?");
					p2r = input.nextInt();
					System.out.println("Which Col would you like?");
					p2c = input.nextInt();
				} while (game.legalMove(p2r, p2c) != true);
				
				//after getting valid input, place move on board, increment move value
				game.setBoard(p2r,p2c, 2);
				game.moveIncrement();
				
				//check if win, or draw
				//If there are less than 5 moves, skip win / draw checks
				if (game.getMoveCounter() >= 4) {
					if (game.winByColumn(2) == true) {
						isOver = true;
					} else if (game.winByDiagonal(2) == true) {
						isOver = true;
					} else if (game.winByRow(2) == true) {
						isOver = true;
					} else if (game.draw() == true) {
						isOver = true;
					}
				}
			}
		} while (isOver == false); //end do while game is not over
	}//end main
}//end class
package tictactoeapplication;

import java.util.Scanner;

public class TicTacToeApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean doYouWantToPlay = true;
		while (doYouWantToPlay) {
			System.out.println("Welcome to tic tac toe! Are you ready? /nFirst you"
					+ "must pick which character you will be and which "
					+ "character I will be.");
			System.out.println();
			System.out.println("Enter a sintgle character that will represent you "
					+ "on the board. ");
			char playerToken = sc.next().charAt(0);
			System.out.println("Enter a single character that will represent your opponent"
					+ "on the board.");
			char opponentToken = sc.next().charAt(0);
			TicTacToe game = new TicTacToe(playerToken, opponentToken);
			AI ai = new AI();
			
			System.out.println();
			System.out.println("Let's start the game. To play enter a number and your "
					+ "token will be placed in it's place. /nThe numbers go from 1 - 9 left"
					+ "to right.");
			TicTacToe.printIndexBoard();
			
			while (game.gameOver().equals("Not Over.")) {
				if(game.currentMarker ==game.userMarker) {
					System.out.println("It's you turn. Enter a spot for your token.");
					int spot = sc.nextInt();
					while(!game.playTurn(spot)) {
						System.out.println("Try again " + spot + " not valid.");
						spot = sc.nextInt();
					}
					System.out.println("You picked " + spot + "!");
						
				}else {
					//AI turn
					System.out.println("It's my turn.");
					int aiSpot = ai.pickSpot(game);
					game.playTurn(aiSpot);
					System.out.println("I picked " + aiSpot + "!");
					
				}
				
				System.out.println();
				game.printBoard();
			}
			System.out.println(game.gameOver());
			System.out.println();
			//new game? y/n
			System.out.println("Do you want to play another game? Press y for yes or"
					+ "anything else for no.");
			char response = sc.next().charAt(0);
			doYouWantToPlay = (response == 'y');
			System.out.println();
			System.out.println();
			
		}
			
		

	}

}

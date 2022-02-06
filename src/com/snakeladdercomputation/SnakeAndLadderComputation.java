package com.snakeladdercomputation;
import java.util.Random;

public class SnakeAndLadderComputation {
	static int playerOnePosition = 0;
	static int playerTwoPosition = 0;
	static final int NO_PLAY = 0;
	static final int LADDER = 1;
	static final int SNAKE = 2;
	static final int PLAYER1 = 1;
	static final int PLAYER2 = 2;
	static int player = PLAYER1;
	public static int diceRoll() {
		Random random = new Random();
		int dice = random.nextInt(6)+1;
		return dice;
	}
	public static int optionCheck(int dice,int position) {
		Random random = new Random();
		int option = random.nextInt(3);
		if((option == LADDER) && (position+dice <= 100)) {
			position += dice;
		}
		else if(option == SNAKE) {
			position -= dice;
		}
		else {
			position = position;
		}
		if(position < 0) {
			position =0;
		}
		if(player == PLAYER1) {
			playerOnePosition = position;
		}
		else if(player == PLAYER2) {
			playerTwoPosition = position;
		}
		return option;
	}
	public static void playerPlayCheck( int option ) {
		if(player == PLAYER1) {
			if((option == SNAKE) || (option == NO_PLAY)) {
				player = PLAYER2;
			}
		}
		else if(player == PLAYER2) {
			if((option == SNAKE) || (option == NO_PLAY)) {
				player = PLAYER1;
			}
		}
	}

	public static void main(String[] args) {
		int dicePlayerOneCount = 0;
		int dicePlayerTwoCount = 0;
		int optionPlayerOne;
		int optionPlayerTwo;
		int option=0;
		while(playerOnePosition < 100 && playerTwoPosition < 100) {
		int dice = diceRoll();
//		System.out.println("dice= "+dice);
		if(player == PLAYER1) {
			optionPlayerOne = optionCheck(dice,playerOnePosition);
			option = optionPlayerOne;
			dicePlayerOneCount++;
		}
		else if(player == PLAYER2) {
			optionPlayerTwo = optionCheck(dice,playerTwoPosition);
			option = optionPlayerTwo;
			dicePlayerTwoCount++;
		}
		playerPlayCheck(option);
		

		}
		System.out.println("playerOnePosition = "+playerOnePosition+"\nplayerTwoPosition = "+playerTwoPosition);
		System.out.println("dicePlayerOneCount = "+dicePlayerOneCount+"\ndicePlayerTwoCount = "+dicePlayerTwoCount);
		if (playerOnePosition == 100) {
				System.out.println("Player 1 Wins");
		}
		else {
				System.out.println("Player 2 Wins");
		}
		
		
	}

}

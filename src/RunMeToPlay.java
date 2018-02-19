/**
 * \file RunMeToPlay.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see RunMeToPlay.java
 *
 * \brief Black Jack Game
 *
 * This class implements an example of the BlackJack game.
 * execute this class to play the game.
 */
/**
 *Begin RunMeToPlay class
 */

import importData.Keyboard;
import Players.Computer;
import Players.Human;
import Players.Player;
import blackJack.*;

public class RunMeToPlay {
	
	public static void main( String[] args) {
		
		Keyboard input = new Keyboard();
		
		System.out.println("Insert the number of real Players");
		int realPlayers = input.getIntInRangeOf(1,3);
		
		System.out.println("Insert the number of Computer Players");
		int compPlayers= input.getIntInRangeOf(0,3); 
		
		int allPlayers = compPlayers + realPlayers + 1;
		
		Player[] players = new Player[allPlayers];
		
		for(int i = 1 ; i < realPlayers + 1 ; i++) {
			System.out.println("Please type the Name of the " + (i) + " Player .");
			players[i] = new Human(input.getString());
		}
		
		System.out.println("Type the difficulty of the Dealer");
		System.out.println("Type easy or normal please .");
		players[0] =  new Computer("Dealer",input.getDefinedStrings("easy","normal"));
		
		for(int i = realPlayers + 1 ; i < allPlayers ; i++) {
			
		System.out.println("Type the difficulty of the " + (i+1) + " computer Player.");
		System.out.println("Type easy or normal");
		players [i] = new Computer("Player no" + (i),input.getDefinedStrings("easy","normal"));
		}
		
		System.out.println("Please insert the number of decks in the lock");
		int numberDecks = input.getIntInRangeOf(1,3);
		
		BlackJack game = new BlackJack(players , numberDecks);
		game.setPlayerList(players);
		
		System.out.println("Would you like to play with Rounds or High Score ?");
		String gameType = input.getDefinedStrings("rounds","score");
		
		if( gameType.equals("rounds"))
			{	
				System.out.println("Please type the number of Rounds");
				int numberRounds = input.getIntInRangeOf(1,10);
				game = new Round(players,numberDecks,numberRounds);
			}
		if(gameType.equals("score"))
			{
				System.out.println("Please type the highest Score");
				double score = input.getDoubleRangeOf(0.1, 20.0);
				game = new HighScore (players,numberDecks,score);
			}
		
		
		game.play();
		System.out.println("Thats all folks");
		game.logic.sortScorelist();
		System.out.println("\nFinal Raking list of the game !!! \n");
		game.out.printScoreList();
		
	}
}
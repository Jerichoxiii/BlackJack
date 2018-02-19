/**
 * \file Round.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see Round.java
 *
 * \brief Sets the game with Rounds
 *
 * This class implements the game of the black Jack with Rounds.It is child class
 * of BlackJack a implements the game with defined number rounds.
 */
/**
 *Begin Round class
 */

package blackJack;

import Players.Player;

public class Round extends BlackJack {
	private int round; // number of rounds to complete the game

/**This constructor implements the game of BlackJack with rounds and initiates the
* parameters of the game . It uses the constructor of its super class to set the players , 
* the lock and also defines the number of the rounds we wish to play
*\ param players
*\ param numberDecks
*\ param rounds
*/
	
	public Round(Player [] players, int numberDecks , int rounds) {
		super(players ,numberDecks);
		this.round = rounds;
	}

/**The method play uses method from its super class to play the game with the defined numbers
 * of rounds.
*\ return currentRound 
*/
	public int play() 
	{
		 while(this.round >= super.currentRound)
			 super.play();
		 return super.currentRound;
	}
}

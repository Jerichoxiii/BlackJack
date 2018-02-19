/**
 * \file HighScore.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see HighScore.java
 *
 * \brief Sets the game with the HighScore
 *
 * This class implements the game of the black Jack with high score.It is child class
 * of BlackJack a implements the game and finishes the game when one or more of the players
 * reaches the defined score.
 */
/**
 *Begin HighScore class
 */

package blackJack;

import Players.Player;

public class HighScore extends BlackJack {
	private double highScore;
	
/**This constructor implements the game of BlackJack with highscore and initiates the
* parameters of the game. It uses the constructor of its super class to set the players , 
* the lock and also defines the score we wish to terminate the game.
*\ param players
*\ param numberDecks
*\ param score
*/
	
	public HighScore( Player[] players , int numberDecks , double score){
		super(players ,numberDecks);
		this.highScore = score;
	}
	
/**This method sets the high score we wish to finish the game.
*\ param score
*\ return currentRound 
*/
	
	public double setHighScore(double score) {
		return this.highScore = score;
	}

/**The method play uses method from its super class play (for a single round) and the game
* to finishes till the one or more players reaches the highscore .
*\ return currentRound 
*/

	public int play() 
	{	
		do {
			super.play();
		}while(this.logic.findHighestScore() <= this.highScore);
		return this.currentRound;
	}	
}
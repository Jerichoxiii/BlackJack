/**
 * \file Logic.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see Logic.java
 *
 * \brief evaluates the information of the players
 *
 * This class receives all the information from a group of players and suports the game to 
 * get decisions. 
 */
/**
 *Begin Logic class
 */

package blackJack;

import Players.Player;

public class Logic {
	
	private Player [] players ;
	
	public Logic(Player [] players) {
		this.players = players;
	}
	
/**This method sorts the given list by Score from the highest to lowest score
*\ returns list
*/	
	
	public Player[] sortScorelist() {
	int n = this.players.length;  
	Player temp ;  
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
				if(this.players[j-1].getScore() < this.players[j].getScore()){  
					//swap elements  
					temp = this.players[j-1];  
					this.players[j-1] = this.players[j];  
					this.players[j] = temp;  
				}  
			}  
	} 
		return this.players;
	}
	
/**This method gets a list of players , evaluates the points each player holds on
 * his hand , and distributes the Score to the winner of each round. The winner
 * gets 1 point and if they are more than one winners this point is shared equal 
 * for each winner . this method returns the number of the winners .
 *\ returns winners
*/
	
	public int shareScore() {
		int winners = 0;
		int toPoints = 0;
		
	for(int i = 0 ; i < players.length ; i++ ) {
		if(false == this.players[i].getBust()) {
		if(toPoints == this.players[i].hand.getPoints())
		{
			winners++;
			toPoints = this.players[i].hand.getPoints();
		}
		if(toPoints < this.players[i].hand.getPoints())
		{
			winners = 1;
			toPoints = this.players[i].hand.getPoints();
		}
	}
	}	
	for(int i = 0 ; i < players.length ; i++ ) {
		if(false == this.players[i].getBust())
			if(toPoints == this.players[i].hand.getPoints())
				this.players[i].addScore((double)1/winners);
	}
	return winners;
	}
	
/**This method gets a list of players , and returns the highest score of all the players
 *\ returns score
*/
	
	public double findHighestScore() {
		double score = 0.0;
		for(int i = 0 ; i < players.length ; i++ )
			if(score < this.players[i].getScore())
				score = players[i].getScore();
		return score;
	}
}

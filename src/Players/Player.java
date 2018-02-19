/**
 * \file Player.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see Player.java
 *
 * \brief Sets the Players in the game
 *
 * This class implements the Player object which has two child classes the Computer
 * and Human but also collaborates with the hand class. This class is responsible to 
 * save and manipulates all the information required for the Player. 
 */
/**
 *Begin Player class
 */

package Players;

import Cards.Hand;

public class Player{
		
	private String Name;
	private double Score;
	private boolean Bust;
	public Hand hand;

/** This constructor sets up a player by setting the name of the player as parameter
 * but also it sets default values in the rest of the variables which define the player
 * @param name
 */
	
	public Player(String name) {
		this.Name = name;
		this.Score =  0.0 ;
		this.Bust = false;
		hand = new Hand();
	} 
	
/** This method sets name in the Player .
 * \param name
 */
	
	public void setName (String name) {this.Name = name;}
	
/** This method returns the name of the Player .
 * \return name
 */	
	public String getName() { return this.Name; }
	
/** This method returns the score of the Player.
 * 
 * \return Score
 */
	
	public double getScore() { return this.Score; }
	
/** This method reset the Score of the Player. 
 */
	
	public void resetScore() { this.Score = 0; }
	
/** This method sets the player to be busted.
 */
	
	public void setBust() { this.Bust = true; }
	
/** This method returns if the player is busted .
* \return (boolean)bust
*/	
	
	public boolean getBust() { return this.Bust; } // Returns if the player is bust
	
/** This method sets the Player non Busted.
*/	
	
	public void resetBust() { this.Bust = false; } // It resets Bust status
	
/** This method returns the decision of the player manual inserted from the parameters
* \ param decision
* \ return (boolean) decision
*/	

	public boolean getDecition() { return true;}
	
/** This method adds Score to the Player but also ensures than the given Score for the parameters
 *  and the existing score is positive. it returns true if it is correct and false if not 
* \ param score
* \ return (boolean)
*/	
	
	public boolean addScore(double score) {
		if(score > 0 && this.Score >= 0) {
		this.Score = this.Score + score;
		return true;
		}
		else
		return false;
	}
	
/** This method prints all the details of the given Player
 */	
	
	public void printStatus() {
		System.out.format("| %11s | %7s | %5s | %6s | \n" 
				, "Name" , "Points" , "Score" , "Bust" );
		System.out.format("| %11s | %7d |  %2.2f | %6b | \n" 
				, this.getName() , this.hand.handPoints() , this.getScore() , this.getBust() );
		if(this.hand.getLength() != 0 ) {
		System.out.format("| %5s | %7s |%2s|%2s | \n" , "Rank" , "Suit" , "Val." , "Num" );
		
		this.hand.printCards();
		System.out.println();
		}
		else
		System.out.println("No Cards");
	}
}

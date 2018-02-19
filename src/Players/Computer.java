/**
 * \file Computer.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see Computer.java
 *
 * \brief Sets the Computer Players in the game
 *
 * This Class implements the child class of the super class Player and it is
 * responsible to evaluate the cards the Computer Players have on their hands
 * and take decisions.
 *
 */
/**
 *Begin Computer class
 */

package Players;

public class Computer extends Player{
	
	private String Difficulty; // Defines the difficulty of the Computer Player
	
 /**This constructor implements the Computer object and initiates the name
 * and the difficulty of the Computer Player
 *\ param name 
 *\ param difficulty
 */

	public Computer(String name , String difficulty) {
		super(name);
		Difficulty = difficulty;
	}
	
/**This method returns the decision of the Computer Player depending on the
 * defined difficulty of this Player. The decision is made depending on the 
 * sum of the point than the Player has 
 *\ 
 *\ returns (boolean) difficulty
 */
	
	public boolean getDecition() {
		int difficulty = 0;
		if (this.Difficulty.equals("normal"))
			 difficulty = 17 ;
		if (this.Difficulty.equals("easy"))
			 difficulty = 20 ;
		if (this.hand.getPoints() <= difficulty) 
			return true;
		else 
			return false;
	}
 
/**This method returns the difficulty that have been set to the Computer Player
 * \return Difficulty
*/

public String getDifficulity () { return Difficulty;} //Returns the difficulty

 /**This method prints all the details of the Computer player in the current time
 */	
	public void printStatus() {
		System.out.format("| %11s | %7s | %5s | %6s | %6s | \n" 
				, "Name" , "Points" , "Score" , "Bust" , "Diff" );
		System.out.format("| %11s | %7d |  %2.2f | %6b | %6s | \n" 
				, this.getName() , this.hand.handPoints() , this.getScore() , this.getBust() , this.getDifficulity());
		if(this.hand.getLength() != 0 ) {
		System.out.format("| %5s | %7s |%2s|%2s | \n" , "Rank" , "Suit" , "Val." , "Num" );
		this.hand.printCards();
		}
		else
		System.out.println("No Cards");
	}

}

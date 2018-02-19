/**
 * \file Hand.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see Hand.java
 *
 * \brief Sets the Hands of the Player
 *
 * This class implements the Hand object which collaborates with the Player class and
 * with the class Card and forms an array of cards that this hand has. 
 * This class is responsible to insert and reset the cards in the hand but also 
 * to evaluate the points from the cards in the hand 
 */
/**
 *Begin Hand class
 */

package Cards;

public class Hand extends ListCard {

	private int Points; // The sum from the value of the cars that the hand has
	
 /**This constructor implements the Hand object and initiates the object with
 * the default values
 */
	
	public Hand() {
		this.numCards = 0;
		this.Points = 0;
	}
	
 /**This method returns the sum of the points from the Value of the cards 
  * that the hand holds. To calculate the points is considers the property 
  * of the Ace to count 11 or 1.
 *\ return points
 */

	public int handPoints() {
		int points = 0;
		int aceCounter = 0;
		Card temp = this.top;
		while(temp != null)
		{	
			points += temp.getValue();
			if(temp.checkFor("Ace") )
				aceCounter++;
			if(points > 21 && aceCounter-- > 0)
				points -= 10;
			temp = temp.next;
		}
		System.out.println(this.Points);
		return this.Points = points;
	}
	
/**This method returns the sum of the points from the Value of the cards 
 * that the hand holds. To calculate the points is considers the property 
 * of the Ace to count 11 or 1.
 *\ return points
 */
	
	public void printCards () {
		Card temp = this.top;
		if (temp == null)
			System.out.println("No Cards in the hand");
		else
		while(temp != null)
		{	
			temp.printCard();
			temp = temp.next;
		}
	}
	
 /**This method returns the Points that all ready the hand has
 *\ return Points
 */		
	
	public int getPoints() { return this.Points; }
	
 /**This method resets the points
 */		
	public void resetPoints() { 
		this.Points = 0 ; 
	} 
}

/**
 * \file Card.java
 * \@author Georgios Papageorgiou
 * \date 14 February 2018
 * \see Card.java
 *
 * \brief Sets the Card in the game
 *
 * This class implements the Card as object and gives the features that a single
 * card and also a function to identify the a single card
 */
/**
 *Begin Card class
 */
package Cards;

public class Card {
	
	protected Card next ;
	private String Suit; // The suit of the card
	private String Rank; // The rank of the card
	private int Value; // The value of the each cards 
	private int DeckNum; // Number of the Deck the card belongs to
	
	private static String[] Suits={"Heart","Diamond","Spade","Club"};
	private static String[] Rakings = {"two","tree","four","five","six","seven","eight","nine","ten","Jack","Queen","King","Ace"};
	private static int[] Values = {2,3,4,5,6,7,8,9,10,10,10,10,11};
	
 /**This constructor implements the Card object and initiates the rank , suit ,
  * deck number and value of the card . To set the values for each feature ,
  * Use the index of the respective array found on the above .
 *\ param suit 
 *\ param rank
 *\ param deckNumb
 */

	public Card (int suit, int rank , int deckNumb) {
		this.setSuit(suit);
		this.setRank(rank);
		this.DeckNum = deckNumb;
		this.next = null;
	}

 /**This constructor implements the Card object and initiates the rank , suit ,
 * deck number and value of the card . This constructor Sets only the rank an the
 * rank by string and the other initialize by default values .
 *\ param suit 
 *\ param rank
 */
	
	public Card (String suit, String rank) {
		this.Suit = suit;
		this.Rank = rank;
		this.Value = 0;
		this.DeckNum = 0;
	}
	

/**This method returns the suit of the card
 *\ returns suit
 */
	
	public String getSuit() { return this.Suit; } // Returns the Suit of the cards

 /**This method returns the Rank of the card
 *\ returns Rank
 */	
	
	public String getRank() { return this.Rank; } // Returns the Rank of the Card

/**This method returns the Value of the card
 *\ returns Value
 */
	
	public int getValue() { return this.Value; } // Returns the Value of the card
	
/**This method returns the getDeckNum of the card
 *\ returns getDeckNum
 */
	
	public int getDeckNum() { return this.DeckNum; } // Returns the number of the deck which the card belongs to
	
/**This method sets the suit in the Card and by using the indexed array for the
 * suit. if the index is out of range the suit is not set and the method returns
 * a boolean false. Otherwise it returns true
 *  the (int) suit
*\ returns boolean
*/
	
	public boolean setSuit(int suit) {
		if(suit>=0 && suit<=3) {
		this.Suit = Suits[suit];
		return true;
		}
		else 
		return false;
	}
	
/**This method sets the Rank in the Card and by using the indexed array for the
 * Rank. if the index is out of range the Rank is not set and the method returns
 * a boolean false. Otherwise it returns true
 *  the (int) rank
*\ returns boolean
*/
	
	public boolean setRank(int rank) {
		
		if(rank>=0 && rank<13) {
		this.Rank = Rakings[rank];
		this.Value = Values[rank];
		return true;
		}
		else 
		return false;
	}
	
/**This method prints all the features that the card contains and returns true . 
 * If there is no card defined it prints "false card" and returns false
 * *\ returns boolean
*/	
	public boolean printCard() {
			System.out.format("| %5s | %7s | %2d | %2d | \n" 
			, this.getRank() , this.getSuit() , this.getValue() , this.getDeckNum() );
			return true;
	}
	
/**This method compares the rank of the given card and returns true if it matches
 * with the given string value. Otherwise returns false.
*\ returns boolean
*/
	
	public boolean checkFor (String rank) {
		if( this.getRank() == rank)
			return true;
		else
			return false;
	}
}

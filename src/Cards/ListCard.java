/**
 * \file Computer.java
 * \author Georgios Papageorgiou
 * \date 16 February 2018
 * \see ListCard.java
 *
 * \brief Sets lists of Cards
 *
 * The ListCard it is implemented by a Singly linked list. It is responsible to
 * insert remove and other operations from a list of Cards. It is supper Class
 * from the Hand and Lock classes. 
 */
/**
 *Begin ListCard class
 */

package Cards;

public class ListCard {
	protected Card top = null; // Top Card in the list
	public int numCards; // number of the cards in the list
	
/** This Constructor creates a list of cards and the inserted card which set
 * as a parameter is the first card in the list 	
 * param card
 */
	public ListCard (Card card) {
		this.top = card;
		this.numCards = 0;
	}
	
/** This Constructor creates an empty list of cards 
 */
	
	public ListCard () {
		this.top = null;
		this.numCards =	0;
		}
		
/** This method inserts a cart on the Top of the list and adds one
 * card in the the counter of the card list
*/

	public void addTop(Card newTop) {
		Card oldTop = this.top;
		this.top = newTop;
		newTop.next = oldTop;
		this.numCards++;
	}

/** This method inserts a cart in the Bottom of the list and adds one
 * card in the the counter of the card list
*/
	
	public void addBottom(Card card) {
		Card current = this.top;
		if(this.top == null) {
		this.top = card;
		this.numCards++;
		}
		else {
		while(current.next != null)
		current = current.next;
		current.next = card;
		this.numCards++;
		}
	}	

/** This method returns the number of the list of the cards
 * 
 * return counter
 */
	
	public int getLength () {
		int counter = 0;
		Card current = this.top;
		while(current != null)
			{
			current = current.next;
			counter++;
			}
		return counter;
	}
	
/** This method chose one card and returns the detached card from the list
 * \ param index . Warning : this method does not changes the number of the cards
 * \ return card 
 * */
	
	public Card detatchCardFrom (int index) {
		Card current = this.top;
		Card previous = null;
		int counter = 0;
		if( this.top == null )
			return current;
		while(current.next != null && counter < index) {
			counter++;
			previous = current;
			current = current.next;	
		}
		if ( previous == null )
			this.top = current.next;
		else if( current.next != null )
			previous.next = current.next;
		else if( current.next == null )
			previous.next = null;
		current.next = null;
		return current;
	}
	
/** This method removes one card from the top , returns the card and
 * Subtracts one card from the numCards
 * return
 */
	
	public Card detacheTop() {
		if(this.top == null)
			return this.top;
		if(this.numCards < 0)
			return null;
		Card oldTop = this.top;
			this.top = this.top.next;
			this.numCards--;
			oldTop.next = null;
				return oldTop;
	}
	
/**This method removes all the cards from the list 
 */
	public void reset() {
		this.top = null;
	}
}

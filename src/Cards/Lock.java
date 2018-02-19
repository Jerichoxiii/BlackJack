/**
 * \file Lock.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see Lock.java
 *
 * \brief Sets lock in the game
 *
 * This class implements the lock and collaborates with the class Card
 */
/**
 *Begin Lock class
 */

package Cards;

public class Lock extends ListCard{ 
	
	private int numberOfDecks; // Number of decks that form the lock

 /**This constructor implements the lock and initiates the the lock
 * .It sets the number of the decks in the lock , 
 *\ param numberOfDecks
 */
	
	public Lock (int numberOfDecks){
		this.numberOfDecks=numberOfDecks;
	}
	
	public void setLock() {
		
	for(int k = 1 ; k <= numberOfDecks ; k++) {
		for(int i = 0 ; i < 4 ; i++) 
			for(int j = 0 ; j < 13 ; j++)
				{
				Card temp = new Card(i , j ,k);
				this.addTop(temp);
				}
		}
	}
	
	public Lock () {}
	
 /**This method shuffles only the cards that they are after the number of usedCards 
  * and returns a true or false if the shuffling is done without or with problems
  * respectively
 *\ return boolean
 */
	
	public boolean shufflle() {
		if(this.top == null)
			return false;
		else {
			Lock temp = new Lock();
			int nCards = this.numCards;
			while(this.top != null) {
				int  number = (int)(Math. random() * nCards--);
				temp.addTop(this.detatchCardFrom(number));
			}
				this.top = temp.top;
		}
		System.out.println("The Cards Have been Shuffled!!!!");
		return true;
	}
	public void newLock() {
		this.top = null;
		Lock newLock = new Lock(this.numberOfDecks);
		this.top = newLock.top;
		System.out.println("New lock whith " + this.numberOfDecks + " Decks has been set");
	}
	
 /**This method prints all the details of all cards in the lock.
 */
		public void printLock() {
			if (this.top  == null )
					System.out.println("No Cards in the Lock !!");
			else {
				Card current = this.top;
				while(current != null) {
					current.printCard();
					current = current.next;
				}
			}
		}		
}

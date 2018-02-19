/**
 * \file BlackJack.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see BlackJack.java
 *
 * \brief Sets the Black Jack Game
 *
 * This class implements the game of the black Jack . It is super class of
 * Round and HighScore and collaborates with Player , Lock and Print classes
 */
/**
 *Begin BlackJack class
 */

package blackJack;

import Cards.Lock;
import Players.Player;

public class BlackJack{

	protected Player[] players; // array of the objects Players
	private Lock lock; // a lock of Cards
	public Print out;// class prints all the details of the players
	protected int currentRound; // number of the current rounds
	public Logic logic; // this class evaluates and estimates the results 

	/**This constructor implements the game of BlackJack and initiates the
* parameters of the game. It sets the players and the number of the deck
* witch the lock will contains .
*\ @param players
*\ @param numberDecks
*/	
	
	public BlackJack (Player [] players, int numberDecks) {
		 this.players = players;
		 this.lock = new Lock(numberDecks);
		 this.lock.setLock();
		 this.lock.shufflle();
		 this.out = new Print(players);
		 this.logic = new Logic(players);
		 this.currentRound=1;
		}	
	
/**This method sets the players who will play the game 
*\ @param players
*/
	
	public void setPlayerList(Player[] players) {
	this.players =  players; 
	}	
	
/**The play method implements the core of the game. It uses the objects
* Initialized by the constructor and runs a single round of the game .
*\ return currentRound
*/
	
	public int play() {
		System.out.println("************* Rounds : " + this.currentRound++ + 
				"***********************************");
		for(int i = 0 ; i < players.length ; i++ ) {
			this.players[i].hand.resetPoints();
			this.players[i].hand.reset();
			this.players[i].resetBust();
		}
		
		for(int i = 0 ; i < players.length ; i++ ) {
			this.players[i].hand.addTop(lock.detacheTop());
			this.players[i].hand.addTop(lock.detacheTop());
		}
		
		for(int i = 0 ; i < players.length ; i++ ) {
			if(lock.numCards < 30) {
				lock.setLock();
				lock.shufflle();
			}
			this.out.printAllStatus();
			while (!this.players[i].getBust())
			 {
				
				if(this.players[i].getDecition()) {
				this.players[i].hand.addBottom(lock.detacheTop());
				System.out.println("The hand poits are : " + this.players[i].hand.handPoints() + " Player : " + i);
				if(this.players[i].hand.handPoints() > 21)
					this.players[i].setBust();
				}
				else
					break;
			}
		}//end for
		this.out.printAllStatus();
		this.logic.shareScore();
		this.out.printPointList();
		this.out.printScoreList();
		return this.currentRound;
		}	
	}
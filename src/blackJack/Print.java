/**
 * \file Print.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see Print.java
 *
 * \brief Print the details all the details of the group of players
 *
 * This class implements the Print class and it is responsible for printing
 * on the command line the information about the players
/**
 *Begin Print class
 */

package blackJack;

import Players.Player;

public class Print {
	Player[] players;
	
	public Print (Player[] players) {
	this.players = players;
	}
	
/**This method Prints in the command line a list with all the details of the players
 */

	public void printAllStatus() {
		System.out.println("******PlayerStatus***************\n");
		for(int i = 0 ; i < players.length ; i++ )
			this.players[i].printStatus();
		System.out.println("\n********************************\n");
		}
	
/**This method Prints in the command line a list with the name and score of the players
*/
	
	public void printScoreList() {
		System.out.println("***********Score List**************\n");
		for (int i = 0 ; i < this.players.length ; i++)
		System.out.format("| %11s | %3.2f | \n" , this.players[i].getName() , this.players[i].getScore() );
		System.out.println("*********************************\n");
	}
	
/**This method Prints in the command line a list with the name and score of the players
*/
	
	public void printPointList() {
		System.out.println("***********Point List************\n");
		for (int i = 0 ; i < this.players.length ; i++) 
		System.out.format("| %11s | %3d | \n" , this.players[i].getName() , this.players[i].hand.getPoints() );
		System.out.println("*********************************\n");

	}
}

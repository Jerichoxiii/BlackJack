/**
 * \file Human.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see Human.java
 *
 * \brief Sets the (real) Human Players in the game
 *
 * This Class implements the child class of the super class Player and it is
 * responsible to get the decision from the keyboard from the (real) Human Players
 *
 */
/**
 *Begin Human class
 */

package Players;

import importData.Keyboard;

public class Human extends Player {	
	
 /**This constructor implements the Human object and initiates the name
 *\ param name 
 */

	public Human(String name) {
		super(name);
	}

 /**This method returns the decision of the Human Player. It asks the player
  * and the player must give the decision typing from the keyboard
 *\ 
 *\ returns boolean(decision)
 */	
	public boolean getDecition() {
		Keyboard input = new Keyboard();
		String decition;
			System.out.println (" , if you want to hit press h else press s");
			decition = input.getDefinedStrings("s", "h");
			if(decition.equals("h"))
			return true;
			else
			return false;
	}
}

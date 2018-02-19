/**
 * \file Keyboard.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see Keyboard.java
 *
 * \brief gets the commands from the keyboard
 * 
 * This class ensures a reliable transition of the commands from the keyboard to the system.
 * It ensures that the derived commands have the correct data type and the right
 * range in numerical types to avoid error
 */
/**
 *Begin Keyboard class
 */

package importData;

import java.util.Scanner;
public class Keyboard {
	Scanner scanner = new Scanner(System.in);
	
/**This method returns the if the given string is integer or not
*\ returns boolean
*/
	
	public static boolean isNumeric(String str)  
	{
		try { int d = Integer.parseInt(str); }
		catch(NumberFormatException nfe) { return false; }
			return true;
	}
	
/**This method returns the if the given string is double or not
*\ returns boolean
*/
	
	public static boolean isDouble(String str)  
	{
		try { double d = Double.parseDouble(str); } 
		catch(NumberFormatException nfe){ return false; }
			return true;  
	}
	
/**This method scans the keyboard and returns double if the string
 * from the keyboard is double
*\ returns (double)number
*/
	private double doubleFromKeyboard() {
		String number;
		while(true) {
			number = scanner.nextLine();
			if (isDouble(number))
			break;
			else
			System.out.println("Invalid input , Type double number please");
		}
		return Double.parseDouble(number); 
	}
	
/**This method scans the keyboard and returns integer if the string
* from the keyboard is integer
*\ returns (integer)number
*/
	
	private int integerFromKeyboard() {
		String number;
		while(true) {
			number = scanner.nextLine();
			if (isNumeric(number))
			break;
			else
			System.out.println("Invalid input , Type integer number please");
		}
		return Integer.parseInt(number); 
	}
	
/**This method scans the keyboard and returns integer if the string
* from the keyboard is integer in the specified range
*\ returns (integer)number
*/
	
	public int getIntInRangeOf (int min , int max) {
		int number;
		while(true) {
		number = integerFromKeyboard();
		if (number < min || number > max)
			System.out.println("This number is out of the accepted range. "
			+ "Please type a number between " +  min + " to " + max + ".");
		else
			break;
		}
		return number ;
	}
	
/**This method scans the keyboard and returns double if the string
* from the keyboard is double in the specified range
*\ returns (double)number
*/
	
	public double getDoubleRangeOf (double min , double max) {
		double number;
		while(true) {
		number = doubleFromKeyboard();
		if (number < min || number > max)
			System.out.println(" This number is out of the accepted range. "
			+ "Please type a number between " +  min + " to " + max + ".");
		else
			break;
		}
		return number ;
	}	
	
/**This method returns the string typed from the keyboard
 *\ return String
 */
	
	public String getString() {
		return scanner.nextLine();
	}

/**This method scans the keyboard and returns the string which matches
 * from the the two given string as parameters
 * param str1
 * param str2
*\ returns string
*/	
	public String getDefinedStrings (String str1 , String str2) {
		String str;
		while(true){
			str = scanner.nextLine();
			if(str.equals(str1) || str.equals(str2))
				break;
			else
				System.out.println("Invalid input Please type " + str1 + " or " + str2 + " .");
			}
		return str;
		}
}

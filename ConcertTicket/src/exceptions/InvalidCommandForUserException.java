/**
 * 
 */
package exceptions;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
@SuppressWarnings("serial")
public class InvalidCommandForUserException extends Exception {

	/**
	 * @param message
	 */
	public InvalidCommandForUserException() {
		super("User cannot execute this command.");
		// TODO Auto-generated constructor stub
	}

}

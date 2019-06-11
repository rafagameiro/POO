/**
 * 
 */
package exceptions;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
@SuppressWarnings("serial")
public class InsufficientSeatsException extends Exception {

	/**
	 * @param message
	 */
	public InsufficientSeatsException() {
		super("There are not sufficient seats for the request.");
		// TODO Auto-generated constructor stub
	}

}

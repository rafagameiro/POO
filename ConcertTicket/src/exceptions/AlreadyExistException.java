/**
 * 
 */
package exceptions;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
@SuppressWarnings("serial")
public class AlreadyExistException extends Exception {

	/**
	 * @param arg0
	 */
	public AlreadyExistException(String e) {
		super(e + " already exists.");
	}

}

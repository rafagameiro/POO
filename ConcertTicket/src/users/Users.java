/**
 * 
 */
package users;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public interface Users {
	
	String getName();
	
	abstract boolean samePassword(String password);

	String getPassword();

}

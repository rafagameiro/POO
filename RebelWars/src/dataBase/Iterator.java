package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */

public interface Iterator<E> {
	
	/**
	 * Generic Iterator
	 */	
	
	/**
	 * Verifies if the value is less than current;
	 * 
	 * @return true or false;
	 */
	boolean hasNext();
	

	/**
	 * Increments the counter by one;
	 * 
	 * @return the object that is in the current value;
	 */
	E next();
}

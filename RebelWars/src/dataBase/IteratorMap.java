/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public interface IteratorMap {
	
	/*
	 * Verifies if there is next line;
	 */
	boolean hasNextRow();
	
	/*
	 * Verifies if there is next column;
	 */
	boolean hasNextCol();
	
	/*
	 * Increments the current line;
	 * Puts the current column to zero;
	 */
	void nextRow();
	
	/*
	 * Returns the map object;
	 * Increments the position of the column by one;
	 */
	mapObject nextCol();
	
}

/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public interface mapObject {
	
	/**
	 * 
	 * @return returns the row position in the map;
	 */
	int getRowPos();
	
	/**
	 * 
	 * @return returns the column position in the map;
	 */
	int getColPos();
	
	/**
	 * sets the variable symbol to have the character as the param symbol;
	 * 
	 * @param symbol character you want to put;
	 */
	abstract void setSymbol(char symbol);
	
	/**
	 * 
	 * @return returns the character the variable symbol contains;
	 */
	abstract char getSymbol();

}

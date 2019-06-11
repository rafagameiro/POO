/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public interface Stormtrooper {
	
	//return types
	
	/**
	 * 
	 * @return returns the number of captured rebels by a stormtrooper;
	 */
	int getNumOfRebels();
	
	/**
	 * 
	 * @return returns the row position in the map;
	 */
	int getXPos();
	
	/**
	 * 
	 * @return returns the column position in the map;
	 */
	int getYPos();
	
	/**
	 * 
	 * @return returns the name of the stormtrooper;
	 */
	String getIdentifier();
	
	/**
	 * 
	 * @return returns the current state of the stormtrooper;
	 */
	String getState();
	
	/**
	 * 
	 * @return returns the current pattern a stortrooper has to follow;
	 */
	String getPattern();
	
	/**
	 * 
	 * @return returns the character that defines the stormtrooper;
	 */
	char getColor();
	
	/**
	 * 
	 * @return returns the character stored in the variable oldChar;
	 */
	char getOldChar();
	
	/**
	 * 
	 * @return returns the character stored in the variable futureChar;
	 */
	char getFutureChar();
	
	/**
	 * checks if the state of the stormtrooper is the same as CAPTURED;
	 * 
	 * @return returns true or false;
	 */
	public boolean isCaptive();
	
	//void types
	
	/**
	 * sets the variable state to has the string CAPTURED;
	 */
	void captured();
	
	/**
	 * it adds a new rebel to the captured rebel's array;
	 * 
	 * @param name name of the captured rebel;
	 * @param row row position in the map;
	 * @param col column position in the map;
	 */
	void addRebel(String name, int row, int col);
	
	/**
	 * increments the value of CountPattern by one;
	 */
	void nextPattern();
	
	/**
	 * changes the value of the value xPos to the same as the param row;
	 * 
	 * @param row row position in the map;
	 */
	void setXPos(int row);
	
	/**
	 * changes the value of the value yPos to the same as the param col;
	 * 
	 * @param col column position in the map;
	 */
	void setYPos(int col);
	
	/**
	 * sets the character stored in the variable oldChar to be the same as the param future;
	 * 
	 * @param future character from a coordinates in the map;
	 */
	void setOldChar(char future);
	
	/**
	 * sets the character stored in the variable futureChar to be the same as the param future;
	 * 
	 * @param symbol character from a coordinates in the map;
	 */
	void setFutureChar(char symbol);
	
	//Iterator types
	
	/**
	 * it will iterate how many rebels were captured by the stormtrooper;
	 * 
	 * @return returns the object an iterator;
	 */
	Iterator<Rebels> capturedJedis();

}

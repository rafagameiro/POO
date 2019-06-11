/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public interface Rebels {
	
	//return types
	
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
	 * @return return the total of collected points;
	 */
	int getPoints();
	
	/**
	 * 
	 * @return returns the total of added coordinates;
	 */
	int getCounter();
	
	/**
	 * 
	 * @return return the rebel's name;
	 */
	String getName();
	
	/**
	 * 
	 * @return return the rebel's state;
	 */
	String getState();
	
	/**
	 * 
	 * @return return the rebel's character;
	 */
	char getCharState();
	
	/**
	 * checks if the string of the variable state is the same as AWAKEN;
	 * 
	 * @return returns true or false;
	 */
	boolean isAwakened();
	
	/**
	 * checks if the string of the variable state is the same as CAPTURED;
	 * 
	 * @return returns true or false;
	 */
	boolean isCaptive();
	
	//void methods
	
	/**
	 * sets the variable state to has the string CAPTURED;
	 */
	void Captured();
	
	/**
	 * it adds the value ten to the value stored in points;
	 */
	void getGun();
	
	/**
	 * sets the value of the variable theForce to five;
	 * sets the variable state to has the string AWAKEN;
	 * changes the character stored in the variable sign to "S";
	 */
	void forceAwakens();
	
	/**
	 * decrements the value of theForce by one;
	 * if the value of theForce reaches zero, the state will change to ACTIVE;
	 * also the character stored in the variable sign will change to "R";
	 */
	void decForce();
	
	/**
	 * it calls the method addCoordenates() to add the new coordinates (row,col);
	 * it sets the variable xPos to be the same as the param row;
	 * it sets the variable yPos to be the same as the param col; 
	 * 
	 * @param row row position in the map;
	 * @param col column position in the map;
	 */
	void move(int row, int col);
	
	/**
	 * it adds a new stormtrooper to the captured stormtrooper's array;
	 * 
	 * @param sign character that belongs to stormtrooper;
	 * @param count serial number of the stormtrooper;
	 * @param row row position in the map;
	 * @param col column position in the map;
	 */
	void addStormtrooper(char sign, int count, int row, int col);
	
	//Iterator types
	
	/**
	 * it will iterate the path followed by the rebel;
	 * 
	 * @return return the object of an iterator;
	 */
	Iterator<Coordenates> jediPath();

}

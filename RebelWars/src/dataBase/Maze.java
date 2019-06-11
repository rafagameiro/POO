/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public interface Maze {
	
	//return types
	
	/**
	 * 
	 * @return total number of rows in map;
	 */
	int getRowCount();
	
	/**
	 * 
	 * @return total number of columns in map;
	 */
	int getColCount();
	
	/**
	 * goes through the param array and if it finds a character "." it increment the value of a local variable by one;
	 * 
	 * @param array contains all the caracters inserted by the user to create the map;
	 * @return how many guns (character ".") there is in the inserted map;
	 */
	int howManyGuns(char array[][]);
	
	/**
	 * 
	 * @param row row position in the map;
	 * @param col column position in the map;
	 * @return symbol that is in those coordenates;
	 */
	char getSymbol(int row, int col);
	
	/**
	 * 
	 * @return returns the character the variable futureCharSign;
	 */
	char setOldChar();
	
	/**
	 * checks if the value of rowCount and colCount its still the standard one;
	 * if yes it means there hasn't been created a map;
	 * 
	 * @return returns true or false;
	 */
	boolean hasMap();
	
	/**
	 * checks if in that position the character is a blank space (" ");
	 * 
	 * @param row row position in the map;
	 * @param col column position in the map;
	 * @return true or false;
	 */
	boolean hasBlankSpace(int row, int col);
	
	/**
	 * checks if in that position the character is a gun (".");
	 * 
	 * @param row row position in the map;
	 * @param col column position in the map;
	 * @return true or false;
	 */
	boolean isGun(int row, int col);
	
	/**
	 * checks if in that position the character is a potion ("P");
	 * 
	 * @param row row position in the map;
	 * @param col column position in the map;
	 * @return true or false;
	 */
	boolean isPotion(int row, int col);
	
	/**
	 * checks if in that position the character is a wall ("#");
	 * 
	 * @param row row position in the map;
	 * @param col column position in the map;
	 * @return true or false;
	 */
	boolean isWall(int row, int col);
	
	/**
	 * checks if in that position the character is a rebel ("R");
	 * 
	 * @param row row position in the map;
	 * @param col column position in the map;
	 * @return true or false;
	 */
	boolean isRebel(int row, int col);
	
	/**
	 * checks if in that position the character is a rebel that drunk a potion ("S");
	 * 
	 * @param row row position in the map;
	 * @param col column position in the map;
	 * @return true or false;
	 */
	boolean isAwakenRebel(int row, int col);
	
	/**
	 * checks if in that position the character is a stormtrooper ("O", "B" or "W");
	 * 
	 * @param row row position in the map;
	 * @param col column position in the map;
	 * @return true or false;
	 */
	boolean isStormtrooper(int row, int col);
	
	//void types
	
	/**
	 * goes through the param array and each character will create a new object, in the same position of array, but in the array of objects, map;
	 * the object can be a blank space or a wall;
	 * 
	 * @param array contains all the characters inserted by the user;
	 * @param rowCount total number of rows;
	 * @param colCount total number of columns;
	 */
	void defineMap(char array[][], int rowCount, int colCount);
	
	/**
	 * in the inserted coordinates it will change the character to "R";
	 * 
	 * @param row row position in the map;
	 * @param col column position in the map;
	 */
	void addRebel(int row, int col);
	
	/**
	 * it will set in the coordinates (row,col) the character that define the rebel;
	 * in the coordinates (oldRow,oldCol) that character will be a blank space (" ");
	 * 
	 * @param oldRow current row position of rebel;
	 * @param oldCol current column position of rebel;
	 * @param sign character that define rebel;
	 * @param row future row position of rebel;
	 * @param col future column position of rebel;
	 */
	void moveRebel(int oldRow, int oldCol, char sign, int row, int col);
	
	/**
	 * it will set in the coordinates (row,col) the character that define the stormtrooper;
	 * firstly it checks if the variable future doesn't contain a blank space (" ") or a character that define a rebel ("R");
	 * if not in the coordinates (oldRow,oldCol) that character will be the character contained in the variable future;
	 * if it has, in the coordinates (oldRow,oldCol) that character will be a blank space (" ");
	 * 
	 * @param oldRow current row position of stormtrooper;
	 * @param oldCol current column position of stormtrooper;
	 * @param future char that was in the position where the stormtrooper is;
	 * @param color character that define stormtrooper;
	 * @param row future row position of stormtrooper;
	 * @param col future column position of stormtrooper;
	 */
	void moveStormtrooper(int oldRow, int oldCol, char future, char color, int row, int col);
	
	/**
	 * will set in the coordinates (row,col) the character that is in the variable symbol;
	 * 
	 * @param symbol character you want to put;
	 * @param row row position in the map;
	 * @param col columns position in the map;
	 */
	void setSymbol(char symbol, int row, int col);
	
	//Iterator types
	
	/**
	 * allows to print the map;
	 * 
	 * @return returns the object of an iterator;
	 */
	IteratorMap Iterator();
	
}

/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public class Coordenates {
	
	//Variables
	/**
	 * creates a x position;
	 * creates a y position;
	 */
	private int xPos;
	private int yPos;
	
	//Constructor
	/**
	 * creates a new object in the inserted coordinates (row,col);
	 * 
	 * @param row row position in the map;
	 * @param col column position in the map;
	 */
	public Coordenates(int row, int col){
		xPos = row;
		yPos = col;
	}
	
	/**
	 * 
	 * @return value in the variable xPos;
	 */
	public int getXPos(){
		return xPos;
	}
	
	/**
	 * 
	 * @return value in the variable yPos;
	 */
	public int getYPos(){
		return yPos;
	}

}

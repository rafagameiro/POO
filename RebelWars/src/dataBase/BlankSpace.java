/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public class BlankSpace extends mapObjectclass {
	
	//Variables
	/**
	 * item will contain the character associated to this class;
	 */
	private char item;
	
	//Constructor
	/**
	 * it will user the super constructor of the class mapObjectclass;
	 * it will define the row and col;
	 * item will contain the same character as the param sign;
	 * 
	 * @param sign character to put in these coordinates;
	 * @param row row position in the map;
	 * @param col column position in the map;
	 */
	public BlankSpace(char sign, int row, int col){
		super(row,col);
		item = sign;
	}

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return item;	
	}

	@Override
	public void setSymbol(char symbol) {
		// TODO Auto-generated method stub
		item = symbol;
	}

}

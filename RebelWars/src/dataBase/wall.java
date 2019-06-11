/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public class wall extends mapObjectclass {
	
	//Variables
	/**
	 * symbol will contain the character associated to this class;
	 */
	private char symbol;
	
	//Constructor
	/**
	 * it will user the super constructor of the class mapObjectclass;
	 * it will define the row and col;
	 * symbol will contain the same character as the param sign;
	 * 
	 * @param sign character to put in these coordinates;
	 * @param row row position in the map;
	 * @param col column position in the map;
	 */
	public wall(char sign, int row, int col){
		super(row,col);
		symbol = sign;
	}

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return symbol;
	}

	@Override
	public void setSymbol(char symbol) {
		// TODO Auto-generated method stub
		this.symbol = symbol;
	}
	

}

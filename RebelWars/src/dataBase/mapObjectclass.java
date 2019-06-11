/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public abstract class mapObjectclass implements mapObject {
	
	//Variables
	/**
	 * the rowPos will be the row position in the map;
	 * the colPos will be the column position in the map;
	 */
	public int rowPos;
	public int colPos;
	
	//Constructor
	/**
	 * the value of rowPos will be the same as the value in the param row;
	 * the value of colPos will be the same as the value in the param col;
	 * 
	 * @param row row position in the map;
	 * @param col column position in the map;
	 */
	public mapObjectclass(int row, int col){
		rowPos = row;
		colPos = col;
	}
	
	@Override
	public int getRowPos(){
		return rowPos;
	}
	
	@Override
	public int getColPos(){
		return colPos;
	}
	
	@Override
	public abstract char getSymbol();

	@Override
	public abstract void setSymbol(char symbol);
		

}

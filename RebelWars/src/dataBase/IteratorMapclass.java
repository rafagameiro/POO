/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public class IteratorMapclass implements IteratorMap {
	
	//Variables
	/**
	 * creates a array of mapObjects;
	 * the rowCount is the number of rows the array map will contain;
	 * the colCount is the number of columns the array map will contain;
	 * the rowCurr will be the current position in the array;
	 * the colCurr will be the current position in the array;
	 */
	private mapObject[][] map;
	private int rowCount;
	private int colCount;
	private int rowCurr;
	private int colCurr;
	
	//Constructor
	/**
	 * it will set the variable map as the same as the param map;
	 * the rowCount will have the same value as the param rowCount;
	 * the colCount will have the same value as the param colCount;
	 * rowCurr will start at zero;
	 * colCurr will start at zero;
	 * 
	 * @param map array of mapObjects;
	 * @param rowCount total of rows in that array;
	 * @param colCount total of columns in that array;
	 */
	public IteratorMapclass(mapObject[][] map, int rowCount, int colCount){
		this.rowCount = rowCount;
		this.colCount = colCount;
		this.map = map;
		rowCurr = 0;
		colCurr = 0;
	}


	@Override
	public boolean hasNextRow() {
		// TODO Auto-generated method stub
		return rowCurr < rowCount;
	}


	@Override
	public boolean hasNextCol() {
		// TODO Auto-generated method stub
		return colCurr < colCount;
	}


	@Override
	public void nextRow() {
		// TODO Auto-generated method stub
		rowCurr++;
		colCurr = 0;
	}


	@Override
	public mapObject nextCol() {
		// TODO Auto-generated method stub
		return map[rowCurr][colCurr++];
	}
	
	
}

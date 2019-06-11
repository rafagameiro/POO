/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */

public class Mazeclass implements Maze {
	
	//Variables
	/**
	 * it creates an array of mapObject objects;
	 * rowCount will be the total of rows that exist in the map;
	 * colCount will be the total of columns that exist in the map;
	 * futureCharSign will keep a "default" char;
	 */
	private mapObject[][] map;
	private int rowCount;
	private int colCount;
	private char futureCharSign;
	
	//Constructor
	/**
	 * Initialises the rowCount at zero;
	 * Initialises the colCount at zero;
	 * creates a new mapObject class with the size of the rowCount and colCount;
	 * it sets the futureCharSign as " ";
	 */
	public Mazeclass(){
		rowCount = 0;
		colCount = 0;
		map = new mapObjectclass[rowCount][colCount];
		futureCharSign = ' ';
	}
	
	//Public methods
	
		//void methods
	
	@Override
	public void defineMap(char array[][], int rowCount, int colCount){
		map = new mapObject[rowCount][colCount];
		this.rowCount = rowCount;
		this.colCount = colCount;
		for(int i = 0; i<rowCount;i++){
			for(int j = 0;j<colCount;j++){
				if(array[i][j] == ' ' || array[i][j] == '.' || array[i][j] == 'P' || array[i][j] == 'W' || array[i][j] == 'B' || array[i][j] == 'O'){
					char sign = array[i][j];
					map[i][j] = new BlankSpace(sign,i,j);
				}else{
					char sign = array[i][j];
					map[i][j] = new wall(sign,i,j);
				}
			}
		}
	}
	
	@Override
	public void addRebel(int row, int col){
		map[row-1][col-1].setSymbol('R');
	}
	
	@Override
	public void moveRebel(int oldRow, int oldCol, char sign, int row, int col){
		setSymbol(sign,row,col);
		setSymbol(' ',oldRow,oldCol);
	}
	
	@Override
	public void moveStormtrooper(int oldRow, int oldCol, char future, char color, int row, int col){
		char oldCharSign = future;
		int oldStormXPos = oldRow;
		int oldStormYPos = oldCol;
		setSymbol(color,row,col);
		if(oldCharSign != 'R' && oldCharSign != ' '){
			setSymbol(oldCharSign,oldStormXPos,oldStormYPos);
		}else{
			setSymbol(' ',oldStormXPos,oldStormYPos);
		}
	}
	
	@Override
	public void setSymbol(char symbol, int row, int col){
		map[row-1][col-1].setSymbol(symbol);
	}
	
	
		//int methods
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowCount;
	}

	@Override
	public int getColCount() {
		// TODO Auto-generated method stub
		return colCount;
	}
	
	@Override
	public int howManyGuns(char array[][]) {
		// TODO Auto-generated method stub
		int guns = 0;
		for(int r = 0;r<rowCount;r++){
			for(int c = 0;c<colCount;c++){
				if(array[r][c] == '.')
					guns++;
			}
		}
		return guns;
	}
	
	
		//char methods
	
	@Override
	public char getSymbol(int row, int col){
		return map[row-1][col-1].getSymbol();
	}
	
	@Override
	public char setOldChar(){
		return futureCharSign;
	}
	
	
		//boolean methods
	
	@Override
	public boolean hasMap(){
		return rowCount != 0 && colCount != 0;
	}
	
	@Override
	public boolean hasBlankSpace(int row, int col){
		return (map[row-1][col-1] instanceof BlankSpace && map[row-1][col-1].getSymbol() == ' ');
	}
	
	@Override
	public boolean isGun(int row, int col){
		return(map[row-1][col-1] instanceof BlankSpace && map[row-1][col-1].getSymbol() == '.');
	}
	
	@Override
	public boolean isPotion(int row, int col){
		return(map[row-1][col-1] instanceof BlankSpace && map[row-1][col-1].getSymbol() == 'P');
	}
	
	@Override
	public boolean isWall(int row, int col){
		return(map[row-1][col-1] instanceof wall);
	}
	
	@Override
	public boolean isRebel(int row, int col){
		return(map[row-1][col-1].getSymbol() == 'R');
	}
	
	@Override
	public boolean isAwakenRebel(int row, int col){
		return(map[row-1][col-1].getSymbol() == 'S');
	}
	
	@Override
	public boolean isStormtrooper(int row, int col){
		return(map[row-1][col-1].getSymbol() == 'B' || map[row-1][col-1].getSymbol() == 'O' || map[row-1][col-1].getSymbol() == 'W');
	}
	
	
		//Iterator methods
	
	@Override
	public IteratorMap Iterator(){
		return new IteratorMapclass(map,rowCount,colCount);
	}
}

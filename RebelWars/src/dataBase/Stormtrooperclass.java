/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public class Stormtrooperclass implements Stormtrooper {
	
	//Constants
	/**
	 * standard size of rebel's array;
	 * possible states of the stormtrooper;
	 * possible directions the stormtrooper can take;
	 */
	static final int DEFAULT = 50;
	static final String CAPTURED = "CAPTURED";
	static final String ACTIVE = "ACTIVE";
	static final String UP = "U";
	static final String DOWN = "D";
	static final String LEFT = "L";
	static final String RIGHT = "R";
	
	//Variables
	/**
	 * creates an array of captured rebels called Anikin;
	 * creates an array with the patterns the stormtrooper has to follow;
	 * the xPos will be the row position in the map;
	 * the yPos will be the column position in the map;
	 * the counter will be total number of captured rebels by one stormtrooper;
	 * the countPattern will define which direction the stormtrooper has to follow;
	 * Identifier will be the name of stormtrooper;
	 * state will say if it's stil ACTIVE or if it was CAPTURED;
	 * the color will be the character that each stormtrooper represents;
	 * oldChar is the character that was in the position where the stormtrooper is now, 
	 * before he moves to there;
	 * futureChar is the charater that is in the position to where the stormtrooper will move; 
	 */
	public Rebels[] Anikin;
	public String[] Patterns; 
	public int xPos;
	public int yPos;
	public int counter;
	public int countPattern;
	public String Identifier;
	public String state;
	public char color;
	public char oldChar;
	public char futureChar;
	
	
	//public methods
	
	public Stormtrooperclass(int row, int col){
		xPos = row;
		yPos = col;
		state = ACTIVE;
		Anikin = new Rebelsclass[DEFAULT];
		counter = 0;
		Patterns = new String[4];
		countPattern = 0;
	}
		//void methods
	
	@Override
	public void addRebel(String name, int row, int col) {
		// TODO Auto-generated method stub
			Anikin[counter++] = new Rebelsclass(name,row,col);
	}

	@Override
	public void captured() {
		// TODO Auto-generated method stub
		state = CAPTURED;
	}

	@Override
	public void nextPattern() {
		// TODO Auto-generated method stub
		if(countPattern == 3){
			countPattern = 0;
		}else	
		countPattern++;	
	}
	
	@Override
	public void setXPos(int row){
		xPos = row;
	}
	
	@Override
	public void setYPos(int col){
		yPos = col;
	}
	
	@Override
	public void setOldChar(char future){
		oldChar = future;
	}
	
	@Override
	public void setFutureChar(char symbol){
		futureChar = symbol;
	}
	
	
		//int methods

	@Override
	public int getNumOfRebels() {
		// TODO Auto-generated method stub
		return counter;
	}
	
	@Override
	public int getXPos() {
		// TODO Auto-generated method stub
		return xPos;
	}

	@Override
	public int getYPos() {
		// TODO Auto-generated method stub
		return yPos;
	}
	
	
		//String methods
	
	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return Identifier;
	}

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return state;
	}
	
	@Override
	public String getPattern() {
		// TODO Auto-generated method stub
		return Patterns[countPattern];
	}
	
	
		//char methods
	
	@Override
	public char getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
	@Override
	public char getOldChar(){
		return oldChar;
	}
	
	@Override
	public char getFutureChar(){
		return futureChar;
	}
	
	
		//boolean methods
	
	@Override
	public boolean isCaptive(){
		return (state.equalsIgnoreCase(CAPTURED));
	}

		//Iterator methods

	@Override
	public Iterator<Rebels> capturedJedis() {
		// TODO Auto-generated method stub
		return new IteratorRebelsclass(Anikin,counter);
	}	
}

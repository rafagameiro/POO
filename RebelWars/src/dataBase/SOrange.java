/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public class SOrange extends Stormtrooperclass {
	
	//Constructor
	/**
	 * it will call the super constructor in the Stormtrooperclass class;
	 * after that it will define the pattern the stormtrooper has to follow;
	 * 
	 * @param serialNumber order of creation between stormtroopers;
	 * @param row row position in the map;
	 * @param col column position in the map;
	 */
	public SOrange(int serialNumber, int row, int col){
		super(row,col);
		super.Identifier = "ST-O-" + Integer.toString(serialNumber);
		super.color = 'O';
		addPattern();
	}
	
	/**
	 * it add to each position a movement the stormtrooper has to follow;
	 */
	private final void addPattern(){
		super.Patterns[0] = RIGHT;
		super.Patterns[1] = DOWN;
		super.Patterns[2] = LEFT;
		super.Patterns[3] = UP;
	}
}

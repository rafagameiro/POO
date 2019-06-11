/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public class SWhite extends Stormtrooperclass {
	
	//Constructor
	/**
	 * it will call the super constructor in the Stormtrooperclass class;
	 * after that it will define the pattern the stormtrooper has to follow;
	 * 
	 * @param serialNumber order of creation between stormtroopers;
	 * @param row row position in the map;
	 * @param col column position in the map;
	 */
	public SWhite(int serialNumber, int row, int col){
		super(row,col);
		super.Identifier = "ST-W-" + Integer.toString(serialNumber);
		super.color = 'W';
		addPattern();
	}
	
	/**
	 * it add to each position a movement the stormtrooper has to follow;
	 */
	private final void addPattern(){
		super.Patterns[0] = LEFT;
		super.Patterns[1] = RIGHT;
		super.Patterns[2] = DOWN;
		super.Patterns[3] = UP;
	}
}

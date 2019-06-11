package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */

public class IteratorStormtrooperclass implements Iterator<Stormtrooper> {
	
	//Variables
	/**
	 * creates a array of stormtrooper;
	 * the SCounter is the number of stormtroopers the array stormtrooper will contain;
	 * the SCurrent will be the current position in the array;
	 */
	private Stormtrooper[] stormtrooper;
	private int SCounter;
	private int SCurrent;
	
	//Constructor
	/**
	 * it will set the variable stormtrooper as the same as the param str;
	 * the SCounter will have the same value as the param counter;
	 * SCurrent will start at zero;
	 * 
	 * @param str array of stormtroopers;
	 * @param counter total of stormtroopers in that array;
	 */
	public IteratorStormtrooperclass(Stormtrooper[] str, int counter){
		stormtrooper = str;
		SCounter = counter;
		SCurrent = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return SCurrent < SCounter;
	}

	@Override
	public Stormtrooper next() {
		// TODO Auto-generated method stub
		return stormtrooper[SCurrent++];
	}

}

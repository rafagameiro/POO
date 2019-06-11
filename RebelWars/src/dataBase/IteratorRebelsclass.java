package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */

public class IteratorRebelsclass implements Iterator<Rebels> {
	
	//Variables
	/**
	 * creates a array of rebels;
	 * the countRebel is the number of rebels the array rebel will contain;
	 * the cuurRebel will be the current position in the array;
	 */
	private Rebels[] rebel;
	private int countRebel;
	private int currRebel;
	
	//Constructor
	/**
	 * it will set the variable rebel as the same as the param rebel;
	 * the countRebel will have the same value as the param counter;
	 * currRebel will start at zero;
	 * 
	 * @param rebel array of rebels;
	 * @param counter total of rebels in that array;
	 */
	public IteratorRebelsclass(Rebels[] rebel, int counter){
		this.rebel = rebel;
		countRebel = counter;
		currRebel = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return currRebel < countRebel;
	}

	@Override
	public Rebels next() {
		// TODO Auto-generated method stub
		return rebel[currRebel++];
	}

}

package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */

public class IteratorCoorclass implements Iterator<Coordenates> {
	
	//Variables
	/**
	 * creates a array of coordinates;
	 * the coorCount is the number of objects the array coor will contain;
	 * the cuurCoor will be the current position in the array;
	 */
	private Coordenates[] coor;
	private int coorCount;
	private int currCoor;
	
	//Constructor
	/**
	 * it will set the variable coor as the same as the param array;
	 * the coorCount will have the same value as the param counter;
	 * currCoor will start at zero;
	 * 
	 * @param coor array of coordinates;
	 * @param counter total of coordinates in that array;
	 */
	public IteratorCoorclass(Coordenates[] coor, int counter){
		this.coor = coor;
		coorCount = counter;
		currCoor = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return currCoor < coorCount;
	}

	@Override
	public Coordenates next() {
		// TODO Auto-generated method stub
		return coor[currCoor++];
	}

}

/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro
 *
 */
public class Iteratorclass implements Iterator {
	
	private int current;
	private int counter;
	private Personclass[] users;
	
	public Iteratorclass(Personclass[] users, int counter){
		current = -1;
		this.counter = counter;
		this.users = users;
	}

	/* (non-Javadoc)
	 * @see dataBase.Iterator#initializeIterator()
	 */
	@Override
	public void initializeIterator() {
		// TODO Auto-generated method stub
		current = 0;
	}

	/* (non-Javadoc)
	 * @see dataBase.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return current < counter;
	}

	/* (non-Javadoc)
	 * @see dataBase.Iterator#Next()
	 */
	@Override
	public Personclass Next(){
		Personclass name = users[current++];
		return name;
	}

}

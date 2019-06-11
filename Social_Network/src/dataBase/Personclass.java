/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro
 *
 */
public class Personclass implements Person {
	
	private String name;
	private String state;
	private Person[]friends;
	private int counter;
	
	public Personclass(String name, String state){
		this.name = name;
		this.state = state;
		friends = new Person[MAX];
		counter = 0;
	}

	/* (non-Javadoc)
	 * @see dataBase.Person#areFriends(java.lang.String)
	 */
	@Override
	public boolean areFriends(String name) {
		// TODO Auto-generated method stub
		boolean are = false;
		for(int i = 0; i< counter;i++){
			if(friends[i].getName().equalsIgnoreCase(name)){
				are = true;
			}
		}
		return are;
	}

	/* (non-Javadoc)
	 * @see dataBase.Person#addFriend(java.lang.String)
	 */
	@Override
	public void addFriend(Person name){
		// TODO Auto-generated method stub
		friends[counter++] = name;
	}

	/* (non-Javadoc)
	 * @see dataBase.Person#addState(java.lang.String)
	 */
	@Override
	public void addState(String name) {
		// TODO Auto-generated method stub
		state = name;
	}

	/* (non-Javadoc)
	 * @see dataBase.Person#getState()
	 */
	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return state;
	}

	/* (non-Javadoc)
	 * @see dataBase.Person#howManyFriends()
	 */
	@Override
	public int howManyFriends() {
		// TODO Auto-generated method stub
		return counter;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}

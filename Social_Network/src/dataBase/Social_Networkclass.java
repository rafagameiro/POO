/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro
 *
 */
public class Social_Networkclass implements Social_Network {
	
	private Personclass[]users;
	private int counter;
	
	public Social_Networkclass(){
		users = new Personclass[MAX];
		counter = 0;
		
	}

	/* (non-Javadoc)
	 * @see dataBase.Social_Network#hasUser(java.lang.String)
	 */
	@Override
	public boolean hasUser(String name) {
		// TODO Auto-generated method stub
		boolean exist = false;
		for(int i = 0; i<counter; i++){
			if(users[i].getName().equalsIgnoreCase(name)){
				exist = true;
			}
		}
		return exist;
	}

	/* (non-Javadoc)
	 * @see dataBase.Social_Network#addUser(java.lang.String)
	 */
	@Override
	public void addUser(String name, String state) {
		// TODO Auto-generated method stub
		users[counter++] = new Personclass(name, state);
	}

	/* (non-Javadoc)
	 * @see dataBase.Social_Network#areFriends(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean areFriends(String name, String name2) {
		// TODO Auto-generated method stub
		boolean friends = false; 
		int pos = searchIndex(name);
		if(users[pos].areFriends(name2)){
			friends = true;
		}
		return friends;
	}

	/* (non-Javadoc)
	 * @see dataBase.Social_Network#addFriends(java.lang.String, java.lang.String)
	 */
	@Override
	public void addFriends(String name1, String name2) {
		// TODO Auto-generated method stub
		int pos = searchIndex(name1);
		int pos2 = searchIndex(name2);
		Person person1 = users[pos];
		Person person2 = users[pos2];
		person1.addFriend(person2);
		person2.addFriend(person1);
	}

	/* (non-Javadoc)
	 * @see dataBase.Social_Network#howManyFriends()
	 */
	@Override
	public int howManyFriends(String name) {
		// TODO Auto-generated method stub
		int howMany = 0;
		for(int i = 0;i < counter;i++){
			if(users[i].getName().equalsIgnoreCase(name)){
				howMany = users[i].howManyFriends();
			}
		}
		return howMany;
	}

	/* (non-Javadoc)
	 * @see dataBase.Social_Network#changeState(java.lang.String)
	 */
	@Override
	public void changeState(String name, String name2) {
		// TODO Auto-generated method stub
		int pos = searchIndex(name);
		users[pos].addState(name2);
	}

	/* (non-Javadoc)
	 * @see dataBase.Social_Network#State(java.lang.String)
	 */
	@Override
	public String State(String name) {
		// TODO Auto-generated method stub
		int pos = searchIndex(name);
		return users[pos].getState();
	}

	public Iteratorclass Usernames(){
		return new Iteratorclass(users, counter);
	}
	
	public int numOfUsers(){
		return counter;
	}
	
	public int searchIndex(String name){
		int pos = -1;
		for(int i = 0; i< counter; i++){
			if(users[i].getName().equalsIgnoreCase(name)){
				pos = i;
			}
		}
		return pos;
	}

}

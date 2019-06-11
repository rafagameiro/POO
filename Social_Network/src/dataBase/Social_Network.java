package dataBase;

public interface Social_Network {
	
	public static final int MAX = 500;
	
	public boolean hasUser(String name);
	
	public void addUser(String name, String state);
	
	public boolean areFriends(String name, String name2);
	
	public void addFriends(String name1, String name2);
	
	public int howManyFriends(String name);
	
	public void changeState(String name, String name2);
	
	public String State(String name);
	
//	public Person socialOn();

}

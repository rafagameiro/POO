package dataBase;

public interface Person {
	
	public static final int MAX = 50;
	
	public boolean areFriends(String name);
	
	public void addFriend(Person name);
	
	public void addState(String name);
	
	public String getState();
	
	public String getName();
	
	public int howManyFriends();

}

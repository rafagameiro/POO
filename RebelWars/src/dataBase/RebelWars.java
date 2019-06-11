package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */

public interface RebelWars {
	
	//void methods
	
	/**
	 * it will create the array of objects, called map through the param array;
	 * it will also goes through the array map, to see if there are stormtrooper;
	 * if there are they will be added to the stromtrooper's array;
	 * finally it will goes through the param array to count how many weapons there are in the whole map;
	 * 
	 * @param array contains the characters that will the object for the maze;
	 * @param row the max number of rows;
	 * @param col the max number of columns;
	 */
	void rogueOne(char array[][], int row, int col);
	
	/**
	 * it creates a new rebel by adding him to the rebel's array;
	 * it will also put the character "R" in the inserted position;
	 * 
	 * @param name name of the rebel;
	 * @param row row position you will put the rebel; 
	 * @param col column position you will put the rebel;
	 */
	void newRebel(String name, int row, int col);
	
	/**
	 * it switches the boolean start to "true";
	 */
	void startBattle();
	
	/**
	 *	goes through the rebel's array;
	 * 	if the rebels was captured it moves to the next one;
	 * 	oldRow is the current row of the rebel;
	 * 	oldCol is the current column of the rebel; 
	 * 	row contains the future row position of rebel;
	 *  col contains the future column position of rebel;
	 * 	
	 *  if the rebel reached the map's limits, found a wall or another rebel, it won't move;
	 * 	checks if in the future position there is a rebel;
	 * 	checks if in the future position has potion; 
	 * 	checks if in the future position has gun; 
	 * 	the last one moves to a blank space;
	 * @param array Contains the future directions of the rebels;
	 */
	void move(String array[]);
	
	/**
	 * goes through the stormtrooper's array;
	 * if the stormtrooper was captured it moves to the next one;
	 * calls the method actionMovement(i);
	 * the i is the position of one stormtrooper in the stormtrooper's array;
	 */
	void moveStormtrooper();
	
	/**
	 * goes through the rebel's array;
	 * if a rebel is awakened, it will decrease the number of times, he can stil remained in that state;
	 * if the value reached zero it will change the character in the current rebel to an "R";
	 * increments the value o rounds by one;
	 */
	void nextRound();
	
	/**
	 * it will put every variable ou array to its default value, so then the user can start the game again;
	 */
	void reset();
	
	//int methods
	
	/**
	 * 
	 * @return the total number of rows existent in the map;
	 */
	int getRowCount();
	
	/**
	 * 
	 * @return the total number of columns existent in the map;
	 */
	int getColCount();
	
	/**
	 * 
	 * @return gives away the total of created stormtroopers;
	 */
	int numOfStormtroopers();
	
	/**
	 * 
	 * @return gives away the total of created rebel;
	 */
	int numOfRebels();
	
	/**
	 * 
	 * @return gives the number of rebels that haven't been captured;
	 */
	int numOfActiveRebels();
	
	/**
	 * 
	 * @return gives the number of stormtroopers that haven't been captured;
	 */
	int numOfActiveStormtroopers();
	
	/**
	 * 
	 * @return shows the current value that is in the variable rounds;
	 */
	int getRounds();
	
	/**
	 * goes through the rebels array and check how many points every rebel has and add it to a local variable;
	 * 
	 * @return value that is in the local variable;
	 */
	int getTotalPoints();
	
	/**
	 * checks how many are stil in the game;
	 * 
	 * @return the value that is the variable totalGuns;
	 */
	int getRemainingGuns();
	
	/**
	 * goes to a rebel and says how many steps has taken;
	 * 
	 * @param name name of rebel;
	 * @return return the value the variable counter;
	 */
	int getCoorCount(String name);
	
	/**
	 * checks how many rebels, a stormtrooper has already captured;
	 * 
	 * @param Identifier name of stormtrooper;
	 * @return number of rebels captured by the stormtrooper;
	 */
	int numOfCapturedRebels(String Identifier);
	
	//String methods
	
	/**
	 * checks if the number of active rebels is zero;
	 * checks if the number of weapons existent in the game is zero;
	 * if one of those conditions is true, it set the battleState has "OVER";
	 * if the game has already started, it set the battleState has "ON";
	 * 
	 * @return the string that is in the variable battleState;
	 */
	String getBattleState();
	
	/**
	 * says what is the state of a rebel;
	 * 
	 * @param name name of a rebel;
	 * @return state of rebel;
	 */
	String getState(String name);
	
	/**
	 * says what is the state of a stormtrooper;
	 * 
	 * @param Identifier name of stormtrooper;
	 * @return state of stormtrooper;
	 */
	String getStormtrooperState(String Identifier);
	
	/**
	 * 
	 * @return the string the variable battleState contains;
	 */
	String battleState();
	
	//boolean methods
	
	/**
	 * goes through the stormtrooper's array, and compares the Identifier of stormtrooper with the param Identifier;
	 * if they are the same it switch the local variable to "true";
	 * if not it will keep it as "false";
	 * 
	 * @param Identifier name of stormtrooper;
	 * @return true or false, if there is or not a stormtrooper;
	 */
	boolean hasStormtrooper(String Identifier);
	
	/**
	 * checks if there is already a defined map or not;
	 * depending on the case it will show a different answer;
	 * 
	 * @return returns true or false;
	 */
	boolean hasRogueOne();
	
	/**
	 * goes through the rebel's array and check there is a rebel with the same as the param name;
	 * if yes it will switch the local variable to "true";
	 * if not it will keep it as "false";
	 * 
	 * @param name name of a rebel;
	 * @return returns true or false;
	 */
	boolean twoJedis(String name);
	
	/**
	 * checks the switch of the variable start;
	 * depending on its switch, the method will return a different value;
	 * 
	 * @return returns true or false;
	 */
	boolean hasStarted();
	
	/**
	 * compares the string in the variable battleState with the string "SETUP";
	 * if they are the same it will return "true";
	 * otherwise it will return "false";
	 * 
	 * @return returns true or false;
	 */
	boolean hasSetup();
	
	/**
	 * checks if the position, in the map, is occupied by a blank space;
	 * if yes, it will return "true";
	 * if not it will return "false";
	 * 
	 * @param row row position inserted by the user;
	 * @param col column position inserted by the user;
	 * @return returns true or false;
	 */
	boolean hasValidPos(int row, int col);
	
	//Iterator methods
	
	/**
	 * it will allow to print the map;
	 * 
	 * @return returns the object iterator;
	 */
	IteratorMap deathStarPlans();
	
	/**
	 * it will iterate all the rebels;
	 * 
	 * @return returns the object iterator;
	 */
	Iterator<Rebels> jediSetting();
	
	/**
	 * it will iterate all the stormtrooper;
	 * 
	 * @return returns the object iterator;
	 */
	Iterator<Stormtrooper> sithSetting();
	
	/**
	 * it will iterate the number of steps and where, the rebel has been;
	 * 
	 * @param name name of rebel;
	 * @return returns the object iterator;
	 */
	Iterator<Coordenates> jediPath(String name);
	
	/**
	 * it will iterate how many rebels were captured by a stormtrooper;
	 * 
	 * @param identifier name of stormtrooper;
	 * @return returns the object iterator;
	 */
	Iterator<Rebels> capturedJedis(String identifier);

}

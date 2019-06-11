/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public class Rebelsclass implements Rebels {
	
	//Constants
	/**
	 * possible states of the rebel;
	 * standard size of coordinates and stormtrooper's array;
	 * possible directions the stormtrooper can take;
	 */
	static final String ACTIVE = "ACTIVE";
	static final String AWAKENS = "SUPERCHARGED";
	static final String CAPTURED = "CAPTURED";
	static final int DEFAULT = 50;
	static final String UP = "U";
	static final String DOWN = "D";
	static final String LEFT = "L";
	static final String RIGHT = "R";
	
	//Variables
	/**
	 * name will contain the name of the rebel;
	 * state will be the state of the rebel;
	 * points is the total of points collected while the game is ON or he isn't CAPTURED;
	 * theForce it's the counter that will initiate after he becomes SUPERCHARGED;
	 * the xPos will be the row position in the map;
	 * the yPos will be the column position in the map;
	 * the array of coordinates will store the path the rebel followed;
	 * coorCount is total number of coordinates;
	 * trooper is the array that has all the stormtroopers that were captured by the rebel;;
	 * countCaptured is the total number of captured Stormtroopers; 
	 * sign is the character that define the rebel;
	 */
	private String name;
	private String state;
	private int points;
	private int theForce;
	private int xPos;
	private int yPos;
	private Coordenates[] coor;
	private int coorCount;
	private Stormtrooper[] trooper;
	private int countCaptures;
	private char sign;
	
	//Constructor
	/**
	 * variable name will have the same string as the param name;
	 * variable xPos will have the same value as the param xPos;
	 * variable yPos will have the same value as the param yPos;
	 * sign has the standard character "R";
	 * the standard number of points is zero;
	 * theForce will start with a -1 value, so then the method forceAwakens() will correctly define the variable;
	 * the standard string to state is ACTIVE;
	 * trooper and coor will have the DEFAULT size;
	 * the standard value of countcaptured is zero;
	 * the standard value of coorCount is zero; 
	 * the first coordinates will be the initial position (xPos,yPos);
	 * 
	 * @param name name of rebel;
	 * @param xPos row position in map;
	 * @param yPos column position in map;
	 */
	public Rebelsclass(String name, int xPos, int yPos){
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		sign = 'R';
		points = 0;
		theForce = -1;
		state = ACTIVE;
		trooper = new Stormtrooper[DEFAULT];
		countCaptures = 0;
		coor = new Coordenates[DEFAULT];
		coorCount = 0;
		addCoordenates(xPos,yPos);
	}
	
	//Public methods
	
		//void methods
	
	@Override
	public void Captured(){
		setState(CAPTURED);
	}
	
	@Override
	public void getGun() {
		// TODO Auto-generated method stub
		points += 10;
	}

	@Override
	public void addStormtrooper(char sign, int count, int row, int col){
		if(countCaptures == trooper.length)
			resizeCaptures();
		if(sign == 'B')
			trooper[countCaptures++] = new SBlack(count,row,col);
		if(sign == 'W')
			trooper[countCaptures++] = new SWhite(count,row,col);
		if(sign == 'O')
			trooper[countCaptures++] = new SOrange(count,row,col);
	}

	@Override
	public void forceAwakens() {
		// TODO Auto-generated method stub
		theForce = 5;
		setState(AWAKENS);
		sign = 'S';
	}

	@Override
	public void decForce() {
		// TODO Auto-generated method stub
		theForce--;
		if(theForce == 0){
			setState(ACTIVE);
			sign = 'R';
		}
	}

	@Override
	public void move(int row, int col) {
		// TODO Auto-generated method stub
			addCoordenates(row,col);
			xPos = row;
			yPos = col;
	}
	
	
		//int methods

	@Override
	public int getXPos() {
		// TODO Auto-generated method stub
		return xPos;
	}

	@Override
	public int getYPos() {
		// TODO Auto-generated method stub
		return yPos;
	}
	
	@Override
	public int getCounter() {
		// TODO Auto-generated method stub
		return coorCount;
	}
	
	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return points;
	}
	
	
		//String methods
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return state;
	}
	
	
		//char methods
	@Override
	public char getCharState(){
		return sign;
	}
	
	
		//boolean methods
	
	@Override
	public boolean isAwakened(){
		// TODO Auto-generated method stub
		return (state.equalsIgnoreCase(AWAKENS));
	}
	
	@Override
	public boolean isCaptive(){
		return (state.equalsIgnoreCase(CAPTURED));
	}

	
		//Iterator methods
	
	@Override
	public Iterator<Coordenates> jediPath(){
		return new IteratorCoorclass(coor, coorCount);
	}
	
	
	//Private methods
	
		//void methods
	
	/**
	 * it adds a new coordinates (row,col) to the array coor;
	 * the coorCount increments by one;
	 * 
	 * @param row row position in the map;
	 * @param col column position in the map;
	 */
	private void addCoordenates(int row, int col) {
		// TODO Auto-generated method stub
		if(coorCount == coor.length)
			resizeCoordenates();
		coor[coorCount++] = new Coordenates(row,col);
	}
	
	/**
	 * it will set the current state of a rebel;
	 * 
	 * @param state can be ACTIVE, SUPERCHARGED or CAPTURED;
	 */
	private void setState(String state) {
		// TODO Auto-generated method stub
		this.state = state;
	}
	
	/**
	 * If the amount of possible coordinates exceeds the coor's array size, it will be created a new array with two times the size of the previous array;
	 * all the previous coordinates, will be moved to that new array;
	 */
	private void resizeCoordenates() {
		// TODO Auto-generated method stub
		Coordenates coorprev[] = new Coordenates[2*coor.length];
		for(int i = 0;i<coorCount;i++){
			coorprev[i] = coor[i];
		}
		coor = coorprev;
	}
	
	/**
	 * If the amount of captured stormtroopers exceeds the trooper's array size, it will be created a new array with two times the size of the previous array;
	 * all the captured stormtroopers, will be moved to that new array;
	 */
	private void resizeCaptures() {
		// TODO Auto-generated method stub
		Stormtrooper trooperprev[] = new Stormtrooperclass[2*coor.length];
		for(int i = 0;i<countCaptures;i++){
			trooperprev[i] = trooper[i];
		}
		trooper = trooperprev;
	}

	
	

}

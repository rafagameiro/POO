/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public class RebelWarsclass implements RebelWars{
	
	//Constants
	/**
	 * defaulted size of stormtrooper and rebel's array;
	 * possible directions, the rebel or stormtrooper can take;
	 */
	static final int DEFAULT = 100;
	static final String UP = "U";
	static final String DOWN = "D";
	static final String LEFT = "L";
	static final String RIGHT = "R";
	
	//Variables
	/**
	 * creates a new map called deathStar;
	 * creates an array that will contain the created rebels;
	 * created an array that will contain the created stormtroopers;
	 * the int yodaCount will be the number of created rebels;
	 * the int countSith will be the number of created stromtroopers;
	 * Scount will be serial number that will define a stormtrooper, aside its color;
	 * rounds will contains the total of rounds until the game finished;
	 * totalGuns has the number of guns that exist in the map;
	 * battleState, says if the battle hasn't started, started or is finished;
	 * start will define if the game started or not;
	 */
	private Maze deathStar;
	private Rebels[] skywalker;
	private Stormtrooper[] stormtrooper;
	private int yodaCount;
	private int countSith;
	private int Scount;
	private int rounds;
	private int totalGuns;
	private String battleState;
	private boolean start;
	
	//Constructor
	/**
	 * creates a new map, array of rebels and stormtroopers;
	 * it will set the value of yodaCount to zero;
	 * it will set the value of countSith to zero;
	 * it will set the value of Scount to one;
	 * it will set the value of yodaCount to zero;
	 * battleState will start as "SETUP";
	 * start will be "false";
	 * the standard number of rounds will be zero;
	 * the standard number of totalGuns will be zero;   
	 */
	public RebelWarsclass(){
		skywalker = new Rebelsclass[DEFAULT];
		stormtrooper = new Stormtrooperclass[DEFAULT];
		deathStar = new Mazeclass();
		yodaCount = 0;
		countSith = 0;
		Scount = 1;
		battleState = "SETUP";
		start = false;
		rounds = 0;
		totalGuns = 0;
	}
	
	
	//Public methods
	
		//void methods
	
	@Override
	public void rogueOne(char array[][], int row, int col){
		deathStar.defineMap(array, row, col);
		newStormtrooper();
		totalGuns = deathStar.howManyGuns(array);
	}
	
	@Override
	public void newRebel(String name, int row, int col){
		if(yodaCount == skywalker.length)
			resizeRebels();
		skywalker[yodaCount++] = new Rebelsclass(name,row,col);
		deathStar.addRebel(row, col);
	}
	
	@Override
	public void startBattle(){
		start = true;
	}
	
	@Override
	public void move(String array[]){
		for(int i = 0;i<yodaCount;i++){
			if(!skywalker[i].isCaptive()){
				int oldRow = skywalker[i].getXPos();
				int oldCol = skywalker[i].getYPos();
				int row = getRebelXDirection(array,i);
				int col = getRebelYDirection(array,i);
				
				if(row == 0 || col == 0 || row > deathStar.getRowCount() || col > deathStar.getColCount() || deathStar.isWall(row, col) || deathStar.isRebel(row, col)){
				}else if(deathStar.isStormtrooper(row, col))
					moveRebelTrooper(oldRow,oldCol,i,row,col);
				else if(deathStar.isPotion(row, col))
					moveRebelPotion(oldRow,oldCol,i,row,col);
				else if(deathStar.isGun(row, col))
					moveRebelGun(oldRow,oldCol,i,row,col);
				else
					moveRebelBlank(oldRow,oldCol,i,row,col);
			}
		}
		
	}
	
	@Override
	public void moveStormtrooper(){
		for(int i = 0;i<countSith;i++){
			if(!stormtrooper[i].isCaptive())
				actionMovement(i);
		}
	}
	
	@Override
	public void nextRound(){
		for(int i = 0;i < yodaCount;i++){
			if(!skywalker[i].isCaptive()){
				int row = skywalker[i].getXPos();
				int col = skywalker[i].getYPos();
				if(skywalker[i].isAwakened())
					skywalker[i].decForce();
				deathStar.setSymbol(skywalker[i].getCharState(), row, col);
			}
		}
		rounds++;
	}
	
	@Override
	public void reset(){
		skywalker = new Rebelsclass[DEFAULT];
		stormtrooper = new Stormtrooperclass[DEFAULT];
		deathStar = new Mazeclass();
		yodaCount = 0;
		countSith = 0;
		Scount = 1;
		battleState = "SETUP";
		start = false;
		rounds = 0;
		totalGuns = 0;
	}
	
	
		//int methods
	
	@Override
	public int getRowCount(){
		return deathStar.getRowCount();
	}
	
	@Override
	public int getColCount(){
		return deathStar.getColCount();
	}
	
	@Override
	public int numOfStormtroopers(){
		return countSith;
	}
	
	@Override
	public int numOfRebels(){
		return yodaCount;
	}
	
	@Override
	public int numOfActiveRebels(){
		int numOfRebels = 0;
		for(int i = 0; i < yodaCount;i++){
			if(!skywalker[i].isCaptive())
				numOfRebels++;
		}
		return numOfRebels;
	}
	
	@Override
	public int numOfActiveStormtroopers(){
		int numOfStormtroopers = 0;
		for(int i = 0; i < yodaCount;i++){
			if(!stormtrooper[i].isCaptive())
				numOfStormtroopers++;
		}
		return numOfStormtroopers;
	}
	
	@Override
	public int getRounds(){
		return rounds;
	}
	
	@Override
	public int getTotalPoints(){
		return setTotalPoints();
	}
	
	@Override
	public int getRemainingGuns(){
		return totalGuns;
	}
	
	@Override
	public int getCoorCount(String name){
		int pos = searchIndex(name);
		return skywalker[pos].getCounter();
	}
	
	@Override
	public int numOfCapturedRebels(String Identifier){
		int pos = searchStormtrooper(Identifier);
		return stormtrooper[pos].getNumOfRebels();
	}
	
	
		//String methods
	
	@Override
	public String getBattleState(){
		if(totalGuns == 0 || numOfActiveRebels() == 0){
			battleState = "OVER";
			start = false;
		}else if(start)
			battleState = "ON";
		return battleState;
	}
	
	@Override
	public String getState(String name){
		int pos = searchIndex(name);
		return skywalker[pos].getState();
	}
	
	@Override
	public String getStormtrooperState(String Identifier){
		int pos = searchStormtrooper(Identifier);
		return stormtrooper[pos].getState();
	}
	
	@Override
	public String battleState() {
		// TODO Auto-generated method stub
		return battleState;
	}
	
	
		//boolean methods
	
	@Override
	public boolean hasStormtrooper(String Identifier){
		boolean has = false;
		for(int i = 0;i < countSith;i++){
			if(stormtrooper[i].getIdentifier().equalsIgnoreCase(Identifier))
				has = true;
		}
		return has;
	}
	
	@Override
	public boolean hasRogueOne(){
		return deathStar.hasMap();
	}
	
	@Override
	public boolean twoJedis(String name){
		boolean theForceIsStrongInYou = false;
		for(int i = 0;i<yodaCount;i++){
			if(skywalker[i].getName().equalsIgnoreCase(name))
				theForceIsStrongInYou = true;
		}
		return theForceIsStrongInYou;
	}
	
	@Override
	public boolean hasStarted(){
		return start;
	}
	
	@Override
	public boolean hasSetup(){
		return battleState.equalsIgnoreCase("SETUP");
	}
	
	@Override
	public boolean hasValidPos(int row, int col){
		return deathStar.hasBlankSpace(row, col);
	}
	
	
		//Iterator methods
	
	@Override
	public IteratorMap deathStarPlans(){
		return deathStar.Iterator();
	}
	
	@Override
	public Iterator<Rebels> jediSetting(){
		return new IteratorRebelsclass(skywalker,yodaCount);
	}
	
	@Override
	public Iterator<Stormtrooper> sithSetting(){
		return new IteratorStormtrooperclass(stormtrooper,countSith);
	}
	
	@Override
	public Iterator<Coordenates> jediPath(String name){
		int pos = searchIndex(name);
		return skywalker[pos].jediPath();
	}
	
	@Override
	public Iterator<Rebels> capturedJedis(String identifier){
		int pos = searchStormtrooper(identifier);
		return stormtrooper[pos].capturedJedis();
	}
	
	
	//Private methods
	
		//void methods
	
	/**
	 * it will go through the object array and check if there is a stormtrooper;
	 * if there is, it will keep the character that is in that position, and verify if the stormtrooper is a black, white or orange one;
	 * after that it will create a stormtrooper in the stormtrooper's array in that position, with the appropriate serial number;
	 * the serial number starts at one;
	 */
	private void newStormtrooper(){	
		for(int r = 0; r < deathStar.getRowCount();r++){
			for(int c = 0;c < deathStar.getColCount();c++){
				if(countSith == stormtrooper.length)
					resizeStormtrooper();
				if(deathStar.isStormtrooper(r+1, c+1)){
					char sign = deathStar.getSymbol(r+1, c+1);
					if(sign == 'B')
						stormtrooper[countSith++] = new SBlack(Scount++,r+1,c+1);
					if(sign == 'O')
						stormtrooper[countSith++] = new SOrange(Scount++,r+1,c+1);
					if(sign == 'W')
						stormtrooper[countSith++] = new SWhite(Scount++,r+1,c+1);
				}
			}
		}
	}
	
	/**
	 * the first if checks if the rebel drunk the potion;
	 * the identifier has the name of Stormtrooper;
	 * the serialNumber has the number of the Stormtrooper;
	 * the pos will have the position of the Stormtrooper in the Stormtrooper's array;
	 * the rebel adds the captured Stormtrooper to its array of captured Stormtroopers;
	 * If in that position there is a gun or a potion, the rebel will take it;
	 * 
	 * If the rebel didn't drink the potion, he will be captured;
	 * the stormtrooper adds the rebel to its array of captured rebels;
	 *
	 * @param oldRow current row of rebel;
	 * @param oldCol current column of rebel;
	 * @param i	position of current rebel in rebels array;
	 * @param row future row of rebel;
	 * @param col future column of rebel;
	 */
	private void moveRebelTrooper(int oldRow, int oldCol, int i, int row, int col){
		if(skywalker[i].isAwakened()){
			String Identifier = getStormtrooperIdentifier(row, col);
			int serialNumber = Integer.parseInt(Identifier.substring(5, Identifier.length()));
			int pos = searchStormtrooper(Identifier);
			skywalker[i].addStormtrooper(stormtrooper[i].getColor(), serialNumber, row, col);
			captureStormtrooper(Identifier);
			if(stormtrooper[pos].getOldChar() == '.'){
				skywalker[i].getGun();
				decGuns();
			}else if(stormtrooper[pos].getOldChar() == 'P')
				skywalker[i].forceAwakens();
			deathStar.moveRebel(oldRow,oldCol,skywalker[i].getCharState(),row, col);
			skywalker[i].move(row,col);
		}else if(!skywalker[i].isAwakened()){
			String name = getRebelName(oldRow,oldCol);
			captureRebel(row,col,i, name, row, col);
			deathStar.setSymbol(' ', oldRow, oldCol);
			skywalker[i].move(row,col);
		}
	}
	
	/**
	 * changes the state of the rebel to supercharged;
	 * 
	 * @param oldRow current row of rebel;
	 * @param oldCol current column of rebel;
	 * @param i	position of current rebel in rebels array;
	 * @param row future row of rebel;
	 * @param col future column of rebel;
	 */
	private void moveRebelPotion(int oldRow, int oldCol, int i, int row, int col){
		skywalker[i].forceAwakens();
		deathStar.moveRebel(oldRow,oldCol,skywalker[i].getCharState(),row, col);
		skywalker[i].move(row,col);
	}
	
	/**
	 * decrements the number of total guns
	 * increments the points of the rebels
	 * 
	 * @param oldRow current row of rebel;
	 * @param oldCol current column of rebel;
	 * @param i	position of current rebel in rebels array;
	 * @param row future row of rebel;
	 * @param col future column of rebel;
	 */
	private void moveRebelGun(int oldRow, int oldCol, int i, int row, int col){
		deathStar.moveRebel(oldRow,oldCol,skywalker[i].getCharState(),row, col);
		skywalker[i].move(row,col);
		skywalker[i].getGun();
		decGuns();
	}
	
	/**
	 * 
	 * @param oldRow current row of rebel;
	 * @param oldCol current column of rebel;
	 * @param i	position of current rebel in rebels array;
	 * @param row future row of rebel;
	 * @param col future column of rebel;
	 */
	private void moveRebelBlank(int oldRow, int oldCol, int i, int row, int col){
		deathStar.moveRebel(oldRow,oldCol,skywalker[i].getCharState(),row, col);
		skywalker[i].move(row,col);
	}
	
	/**
	 * Decreases the number of total guns in the maze;
	 */
	private void decGuns(){
		totalGuns--;
	}
	
	/**
	 * The stormtrooper adds the rebel to its captured rebels array;
	 * The state of the captured rebel is switched to "captured";
	 * 
	 * @param oldRow current row of stormtrooper;
	 * @param oldCol current column of stormtrooper;
	 * @param i	position of current rebel in rebels array;
	 * @param row position of rebel in the rows;
	 * @param col position of rebel in the columns;
	 */
	private void captureRebel(int oldRow, int oldCol, int pos, String name, int row, int col){
		int trooperPos = searchStormtrooper(getStormtrooperIdentifier(oldRow,oldCol));
		stormtrooper[trooperPos].addRebel(name, row, col);
		skywalker[pos].Captured();
	}
	
	/**
	 * changes the stormtrooper state to "captured";
	 * 
	 * @param name Identifier of Stormtrooper;
	 */
	private void captureStormtrooper(String name){
		int pos = searchStormtrooper(name);
		stormtrooper[pos].captured();
	}
	
	/**
	 * the oldRow will get the current row position of stormtrooper;
	 * the oldCol will get the current column position of stormtrooper;
	 * int row contains the future row position of stormtrooper;
	 * int col contains the future column position of stormtrooper;
	 * 
	 * if the stormtrooper reached the map's limits, found a wall or another stormtrooper,
	 * it will change to the next direction to follow and call the method again;
	 * 
	 * if it will find a rebel, he will capture them;
	 * if it will find a rebel that drunk the potion, the stormtrooper will be captured;
	 * if it will find a potion or gun the stormtrooper won't see it;
	 * if it will move to a blank space, he will just move;
	 * 
	 * @param i position of stormtrooper in the stormtrooper's array;
	 */
	private void actionMovement(int i){
		int oldRow = stormtrooper[i].getXPos();
		int oldCol = stormtrooper[i].getYPos();
		int row = getTrooperXDirection(i);
		int col = getTrooperYDirection(i);
		
		if(row == 0 || col == 0 || row > deathStar.getRowCount() || col > deathStar.getColCount() || deathStar.isWall(row, col) || deathStar.isStormtrooper(row, col)){
			stormtrooper[i].nextPattern();
			actionMovement(i);
		}else if(deathStar.isRebel(row,col))
			moveTrooperRebel(oldRow,oldCol,i,row,col);
		else if(deathStar.isAwakenRebel(row, col))
			moveTrooperAwakenRebel(oldRow,oldCol,i,row,col);
		else if(deathStar.isPotion(row, col) || deathStar.isGun(row, col))
			moveTrooperGunPotion(oldRow,oldCol,i,row,col);
		else
			moveTrooperBlank(oldRow,oldCol,i,row,col);
		
	}
	
	/**
	 * the stormtrooper will capture the rebel, and add them to its captured rebel's array;
	 * also it will move to that position;
	 * if in the previous position (oldRow,oldCol), there was a potion/gun, the oldChar will leave the character in that position;
	 * after that the oldChar and futureChar, will be "reseted";
	 * 
	 * @param oldRow current row of stormtrooper;
	 * @param oldCol current column of stormtrooper;
	 * @param i	position of current stormtrooper in stormtrooper's array;
	 * @param row future row of stormtrooper;
	 * @param col future column of stormtrooper;
	 */
	private void moveTrooperRebel(int oldRow, int oldCol, int i, int row, int col){
			char color = stormtrooper[i].getColor();
			String name = getRebelName(row,col);
			int pos = searchIndex(name);
			captureRebel(oldRow,oldCol,pos, name, row, col);
			deathStar.moveStormtrooper(oldRow,oldCol,stormtrooper[i].getOldChar(),color,row,col);
			stormtrooper[i].setXPos(row);
			stormtrooper[i].setYPos(col);
			stormtrooper[i].setFutureChar(deathStar.setOldChar());
			stormtrooper[i].setOldChar(deathStar.setOldChar());
	}
	
	/**
	 * the stormtrooper will be captured by the awakened rebel, add it will be added to the rebel's captured stormtrooper array;
	 * Even though it was captured the last position of stormtrooper will be the position where the rebel was;
	 * the stormtrooper state will be switched to "captured";
	 * 
	 * @param oldRow current row of stormtrooper;
	 * @param oldCol current column of stormtrooper;
	 * @param i	position of current stormtrooper in stormtrooper's array;
	 * @param row future row of stormtrooper;
	 * @param col future column of stormtrooper;
	 */
	private void moveTrooperAwakenRebel(int oldRow, int oldCol, int i, int row, int col){
		char color = stormtrooper[i].getColor();
		String Identifier = stormtrooper[i].getIdentifier();
		int serialNumber = Integer.parseInt(Identifier.substring(4, Identifier.length()));
		int pos = searchIndex(row,col);
		skywalker[pos].addStormtrooper(color, serialNumber, row, col);
		stormtrooper[i].setXPos(row);
		stormtrooper[i].setYPos(col);
		captureStormtrooper(Identifier);
		deathStar.setSymbol(stormtrooper[i].getOldChar(), oldRow, oldCol);
	}
	
	/**
	 * the stormtrooper will move to the position where it is a potion or gun;
	 * since both of them are hidden from the stormtrooper, the character that define the potion/gun, will be kept in a variable called futureChar;
	 * then the stormtrooper will move to that position, and the futureChar	will tranfer the character to another variable called oldChar;
	 * 
	 * @param oldRow current row of stormtrooper;
	 * @param oldCol current column of stormtrooper;
	 * @param i	position of current stormtrooper in stormtrooper's array;
	 * @param row future row of stormtrooper;
	 * @param col future column of stormtrooper;
	 */
	private void moveTrooperGunPotion(int oldRow, int oldCol, int i, int row, int col){
		char color = stormtrooper[i].getColor();
		stormtrooper[i].setOldChar(stormtrooper[i].getFutureChar());
		stormtrooper[i].setFutureChar(deathStar.getSymbol(row, col));
		deathStar.moveStormtrooper(oldRow,oldCol,stormtrooper[i].getOldChar(),color,row,col);
		stormtrooper[i].setXPos(row);
		stormtrooper[i].setYPos(col);
		stormtrooper[i].setOldChar(stormtrooper[i].getFutureChar());
	}
	
	/**
	 * the stormtrooper will move to a blank space position;
	 * if in the previous position (oldRow, oldCol) there was a potion/gun, the variable, oldChar, will leave it in that position;
	 * after that oldChar and futureChar, will be "reseted";
	 * 
	 * @param oldRow current row of stormtrooper;
	 * @param oldCol current column of stormtrooper;
	 * @param i	position of current stormtrooper in stormtrooper's array;
	 * @param row future row of stormtrooper;
	 * @param col future column of stormtrooper;
	 */
	private void moveTrooperBlank(int oldRow, int oldCol, int i, int row, int col){
		char color = stormtrooper[i].getColor();
		deathStar.moveStormtrooper(oldRow,oldCol,stormtrooper[i].getOldChar(),color,row,col);
		stormtrooper[i].setXPos(row);
		stormtrooper[i].setYPos(col);
		stormtrooper[i].setFutureChar(deathStar.setOldChar());
		stormtrooper[i].setOldChar(deathStar.setOldChar());
	}
	
	/**
	 * If the amount of rebels exceeds the rebel's array size, it will be created a new array with two times the size of the previous array;
	 * all the created rebels, will be moved to that new array;
	 */
	private void resizeRebels(){
		Rebels rebelprev[] = new Rebelsclass[2*skywalker.length];
		for(int i = 0;i<yodaCount;i++){
			rebelprev[i] = skywalker[i];
		}
		skywalker = rebelprev;
	}
	
	/**
	 * If the amount of stormtroopers exceeds the stormtrooper's array size, it will be created a new array with two times the size of the previous array;
	 * all the created stormtroopers, will be moved to that new array;
	 */
	private void resizeStormtrooper(){
		Stormtrooper trooperprev[] = new Stormtrooperclass[2*stormtrooper.length];
		for(int i = 0;i<countSith;i++){
			trooperprev[i] = stormtrooper[i];
		}
		stormtrooper = trooperprev;
	}
	

		//int methods
	
	/**
	 * It will sum the total of points collected by the rebels;
	 * 
	 * @return the total of the sum;
	 */
	private int setTotalPoints(){
		int totalPoints = 0;
		for(int i = 0;i<yodaCount;i++){
			totalPoints += skywalker[i].getPoints();
		}
		return totalPoints;
	}
	
	/**
	 * 
	 * @param array contains the direction, that the user chose to rebels follow;
	 * @param pos current position of the rebel and the appointed direction in the arrays;
	 * @return future row position of rebel;
	 */
	private int getRebelXDirection(String array[],int pos) {
		// TODO Auto-generated method stub
		int row = skywalker[pos].getXPos();
		String dir = array[pos];
		if(dir.equalsIgnoreCase(UP))
			row--;
		if(dir.equalsIgnoreCase(DOWN))
			row++;
		return row;	
	}
	
	/**
	 * 
	 * @param array contains the direction, that the user chose to rebels follow;
	 * @param pos current position of the rebel and the appointed direction in the arrays;
	 * @return future column position of rebel;
	 */
	private int getRebelYDirection(String array[],int pos) {
		// TODO Auto-generated method stub
		int col = skywalker[pos].getYPos();
		String dir = array[pos];
		if(dir.equalsIgnoreCase(LEFT))
			col--;
		if(dir.equalsIgnoreCase(RIGHT))
			col++;
		return col;
	}	
	
	/**
	 * 
	 * @param pos current position of the stormtrooper in the stormtrooper's array;
	 * @return future row position of stormtrooper;
	 */
	private int getTrooperXDirection(int pos) {
		// TODO Auto-generated method stub
		int row = stormtrooper[pos].getXPos();
		String dir = stormtrooper[pos].getPattern();
		if(dir.equalsIgnoreCase(UP))
			row--;
		if(dir.equalsIgnoreCase(DOWN))
			row++;
		return row;	
	}
	
	/**
	 * 
	 * @param pos current position of the stormtrooper in the stormtrooper's array;
	 * @return future column position of stormtrooper;
	 */
	private int getTrooperYDirection(int pos) {
		// TODO Auto-generated method stub
		int col = stormtrooper[pos].getYPos();
		String dir = stormtrooper[pos].getPattern();
		if(dir.equalsIgnoreCase(LEFT))
			col--;
		if(dir.equalsIgnoreCase(RIGHT))
			col++;
		return col;
	}
	
	/**
	 * it will go through the rebel's array and compared the rebel name with the param name;
	 * after that it will keep the position of array in the variable pos;
	 * 
	 * @param name name of rebel you want to find;
	 * @return position of the rebel in the rebel's array;
	 */
	private int searchIndex(String name){
		int pos = 0;
		for(int i = 0;i< yodaCount;i++){
			if(skywalker[i].getName().equalsIgnoreCase(name))
				pos = i;
		}
		return pos;
	}
	
	/**
	 * it will go through the rebel's array and compared the rebel position (x,y) with the param row and col;
	 * after that it will keep the position of array in the variable pos;
	 * 
	 * @param row position of some row in the map;
	 * @param col position of some column in the map;
	 * @return position of the rebel in the rebel's array;
	 */
	private int searchIndex(int row, int col) {
		// TODO Auto-generated method stub
		int pos = 0;
		for(int i = 0;i< yodaCount;i++){
			if(skywalker[i].getXPos() == row && skywalker[i].getYPos() == col)
				pos = i;
		}
		return pos;
	}
	
	/**
	 * it will go through the stormtrooper's array and compared the stormtrooper's identifier with the param name;
	 * after that it will keep the position of array in the variable pos;
	 * 
	 * @param name stormtrooper's identifier you want to find;
	 * @return position of the stormtrooper in the stormtrooper's array;
	 */
	private int searchStormtrooper(String name){
		int pos = 0;
		for(int i = 0;i< countSith;i++){
			if(stormtrooper[i].getIdentifier().equalsIgnoreCase(name))
				pos = i;
		}
		return pos;
	}
	
	
		//String methods
	
	/**
	 * it will go through the rebel's array and compared the rebel position (x,y) with the param row and col;
	 * after that it will keep the name of rebel in the variable name;
	 * 
	 * @param row position of some row in the map;
	 * @param col position of some column in the map;
	 * @return name of rebel;
	 */
	private String getRebelName(int row, int col){
		String name = "";
		for(int i = 0; i < yodaCount;i++){
			if(skywalker[i].getXPos() == row && skywalker[i].getYPos() == col)
				name = skywalker[i].getName();
		}
		return name;
	}
	
	/**
	 * it will go through the stormtrooper's array and compared the stormtrooper position (x,y) with the param row and col;
	 * after that it will keep the stormtrooper identifier in the variable name;
	 * 
	 * @param row position of some row in the map;
	 * @param col position of some column in the map;
	 * @return stormtrooper identifier;
	 */
	private String getStormtrooperIdentifier(int row, int col){
		String Identifier = "";
		for(int i = 0; i < countSith;i++){
			if(stormtrooper[i].getXPos() == row && stormtrooper[i].getYPos() == col)
				Identifier = stormtrooper[i].getIdentifier();
		}
		return Identifier;
	}

}

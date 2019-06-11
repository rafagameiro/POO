import java.util.Scanner;
import dataBase.RebelWars;
import dataBase.RebelWarsclass;
import dataBase.Rebels;
import dataBase.Stormtrooper;
import dataBase.Coordenates;
import dataBase.Iterator;
import dataBase.IteratorMap;
/**
 * 
 */




/**
 * @author Rafael Gameiro & Rui Santos
 *
 */
public class Main {
	
	
		//Constants that define the inputs
		private static final String UPLOAD = "UPLOAD";
		private static final String PRINT = "PRINT";
		private static final String REBEL = "REBEL";
		private static final String START = "START";
		private static final String MOVE = "MOVE";
		private static final String LIST = "LIST"; 
		private static final String ALL = "ALL";
		private static final String REBELS = "REBELS";
		private static final String STORMTROOPERS = "STORMTROOPERS";
		private static final String LIST_PATH = "PATH";
		private static final String LIST_PRISONERS = "PRISONERS";
		private static final String RESET = "RESET";
		private static final String EXIT = "EXIT";
		
		
		//Constants that define the system messages
		private static final String MAZE_ACCEPTED = "Maze accepted.";
		private static final String MAZE_DEFINED = "Maze already defined.";
		private static final String MAZE_UNDEFINED = "Maze is undefined.";
		private static final String GAME_STARTED = "Game setup has already finished.";
		private static final String GAME_ISNT_ON = "Game is not on.";
		private static final String GAME_NOT_STARTED = "Game has not started.";
		private static final String REBEL_ADDED = "Rebel added.";
		private static final String REBEL_EXISTENT = "Rebel name already exists.";
		private static final String REBEL_NEEDED = "Game needs a rebel.";
		private static final String REBEL_NOT_EXISTENT = "Rebel does not exist.";
		private static final String STPER_NOT_EXISTENT = "Stormtrooper does not exist.";
		private static final String INVALID_MAZE = "Invalid maze position.";
		private static final String NOTHING_TO_LIST = "Nothing to list.";
		private static final String GAME_RESTARTED = "Game was reset.";
		private static final String EXIT_GAME = "Exiting.";
		
		
		/**
		 * @param args 
		 */
		public static void main(String[] args) {
			
			Scanner in = new Scanner(System.in);
			RebelWars rw = new RebelWarsclass();
			String command = getCommand(in);
			
			while (!command.equals(EXIT)){
				switch(command){
				case UPLOAD: 
					uploadMaze(in,rw);
					break;
				case PRINT:
					printMaze(rw);
					break;
				case REBEL:
					addRebel(in,rw);
					break;
				case START:
					battleStarts(rw);
					break;
				case MOVE:
					move(in,rw);
					break;
				case LIST:  
					String option = in.next().toUpperCase();
					switch(option){
					case ALL:
						listAll(rw);
						break;
					case REBELS:
						listRebels(rw);
						break;
					case STORMTROOPERS:
						listStormtroopers(rw);
						break;
					case LIST_PATH:
						jediPath(in,rw);
						break;
					case LIST_PRISONERS:
						showPrisoners(in,rw);
						break;	
					}
					break;
				case RESET:
					resetGame(rw);
					break;
				}
				System.out.println();
				command = getCommand(in);
			}
			System.out.println(EXIT_GAME);
			System.out.println();
			in.close();
			
		}
		
		/**
		 * uploads the map;
		 * the user insert two numbers that will define the number of rows and columns;
		 * the user types the map he wants to create;
		 * 
		 * if there is already a maze it will print a system message;
		 * otherwise it will confirm the upload;
		 * 
		 * @param in input by the user;
		 * @param rw uses methods from the class RebelWars;
		 */
		private static void uploadMaze(Scanner in, RebelWars rw) {
			// TODO Auto-generated method stub
			int row = in.nextInt();
			int col = in.nextInt(); in.nextLine();
			char[][] map = new char[row+1][col+1];
			for (int r=0; r<row; r++) {
				String line = in.nextLine();
				for (int c=0; c<col; c++)
					map[r][c] = line.charAt(c);
			}
			if (rw.hasRogueOne()) 
				System.out.println(MAZE_DEFINED);
			else {
				rw.rogueOne(map,row,col);
				System.out.println(MAZE_ACCEPTED);
			}
		}
		
		/**
		 * prints the uploaded map created by the user;
		 * if there isn't a maze it will print a system message;
		 * otherwise it will print the map typed by the user;
		 * 
		 * @param rw uses methods from the class RebelWars;
		 */
		private static void printMaze(RebelWars rw) {
			// TODO Auto-generated method stub
			if(!rw.hasRogueOne()){
				System.out.println(MAZE_UNDEFINED);
			}else{
				IteratorMap it = rw.deathStarPlans();
				while(it.hasNextRow()){
					if(!(it.hasNextCol())){
						System.out.println();
						it.nextRow();
					}else
						System.out.print(it.nextCol().getSymbol());
				}
			if(rw.hasStarted() || rw.battleState() == "OVER")
				System.out.println("Points: " + rw.getTotalPoints() + " Timer: " + rw.getRounds() + " Rebels: " + rw.numOfActiveRebels() + " Game: " + rw.getBattleState() + ".");
		}	
		}
		
		/**
		 * the operation adds a rebel to the map;
		 * the user insert the name of the rebel, and its initial coordinates (row,col);
		 * if there isn't a map it will print a system message;
		 * if the game has already started it will print a system message;
		 * if there is already a rebel with the same as the name inserted by the user, it will print a system message;
		 * if the coordinates (row,col) are out of bounds or the coordinates aren't occupied by a blank space, it will print a system message;
		 * otherwise it create a new rebel and add it to the position inserted by the user;
		 * 
		 * @param in input by the user;
		 * @param rw uses methods from the class RebelWars;
		 */
		private static void addRebel(Scanner in, RebelWars rw) {
			// TODO Auto-generated method stub
			String name = in.next();
			int row = in.nextInt();
			int col = in.nextInt(); in.nextLine();
			if(!rw.hasRogueOne()){
				System.out.println(MAZE_UNDEFINED);
			}else if(rw.hasStarted()){
				System.out.println(GAME_STARTED);
			}else if(rw.twoJedis(name)){
				System.out.println(REBEL_EXISTENT);
			}else if((col > rw.getColCount()) || (row > rw.getRowCount()) || (col == 0) || (row == 0) || (!rw.hasValidPos(row, col))){
				System.out.println(INVALID_MAZE);
			}else{
				rw.newRebel(name, row, col);
				System.out.println(REBEL_ADDED);
			}
		}
		
		/**
		 * the operation initiates a game;
		 * if there isn't a defined maze, it will print a system message;
		 * if the game has already started, it will print a system message;
		 * if there wasn't created a rebel, it will print a system message;
		 * otherwise it will starts the battle;
		 * it will print how many points where collected (0), 
		 * how many rounds have passed since the beginning (0) and the game state ("ON");
		 * 
		 * @param rw uses methods from the class RebelWars;
		 */
		private static void battleStarts(RebelWars rw) {
			// TODO Auto-generated method stub
			if(!rw.hasRogueOne()){
				System.out.println(MAZE_UNDEFINED);
			}else if(rw.hasStarted()){
				System.out.println(GAME_STARTED);
			}else if(rw.numOfRebels() == 0){
				System.out.println(REBEL_NEEDED);
			}else{
				rw.startBattle();
				System.out.println("Points: " + rw.getTotalPoints() + " Timer: " + rw.getRounds() + " Rebels: " + rw.numOfActiveRebels() + " Game: " + rw.getBattleState() + ".");
			}
		}
		
		/**
		 * the user will insert directions to command the rebels;
		 * each direction correspond to a single rebel, and if the user has four active rebels, 
		 * he can only insert four directions;
		 * if the game hasn't started, it will print a system message;
		 * otherwise it will move first the rebels and then the stormtroopers;
		 * after the end of a turn it will print how many points where collected, 
		 * how many rounds have passed since the beginning and the game state ("ON" or "OVER");
		 * 
		 * @param in input by the user;
		 * @param rw uses methods from the class RebelWars;
		 */
		private static void move(Scanner in, RebelWars rw) {
			// TODO Auto-generated method stub
			String array[] = new String[rw.numOfActiveRebels()+1];
			for(int i = 0;i<rw.numOfActiveRebels();i++){
				String line = in.next().toUpperCase();
				array[i] = line;
			}
			if(!rw.hasStarted()){
				System.out.println(GAME_ISNT_ON);
			}else{
				rw.move(array);
				rw.moveStormtrooper();
				rw.nextRound();
				System.out.println("Points: " + rw.getTotalPoints() + " Timer: " + rw.getRounds() + " Rebels: " + rw.numOfActiveRebels() + " Game: " + rw.getBattleState() + ".");
			}
		}
		
		/**
		 * it will list all the characters playing the game (rebels and stormtroopers);
		 * if there isn't a map, it will print system message;
		 * if the number of stormtroopers and rebels is zero, it will print a system message;
		 * otherwise it will all the characters, first the stormtroopers and then the rebels;
		 * 
		 * @param rw uses methods from the class RebelWars;
		 */
		private static void listAll(RebelWars rw) {
			// TODO Auto-generated method stub
			if(!rw.hasRogueOne()){
				System.out.println(MAZE_UNDEFINED);
			}else if(rw.numOfStormtroopers() == 0 && rw.numOfRebels() == 0){
				System.out.println(NOTHING_TO_LIST);
			}else{
				System.out.println("All avatars:");
				Iterator<Stormtrooper> itStormtrooper = rw.sithSetting();
				while(itStormtrooper.hasNext()){
					Stormtrooper str = itStormtrooper.next();
					System.out.println(str.getIdentifier() + " " + str.getXPos() + " " + str.getYPos() + " " + str.getState());
				}
				Iterator<Rebels> itRebel = rw.jediSetting();
				while(itRebel.hasNext()){
					Rebels rebel = itRebel.next();
					System.out.println(rebel.getName() + " " + rebel.getXPos() + " " + rebel.getYPos() + " " + rebel.getState() + " " + rebel.getPoints());
				}
			}
		}
		
		/**
		 * it will list all the active rebels;
		 * if there isn't a map, it will print system message;
		 * if the number of active rebels is zero, it will print a system message;
		 * otherwise it will all the active rebels, by order of creation;
		 * 
		 * @param rw uses methods from the class RebelWars;
		 */
		private static void listRebels(RebelWars rw) {
			// TODO Auto-generated method stub
			if(!rw.hasRogueOne()){
				System.out.println(MAZE_UNDEFINED);
			}else if(rw.numOfActiveRebels() == 0){
				System.out.println(NOTHING_TO_LIST);
			}else{
				System.out.println("Rebels:");
				Iterator<Rebels> it = rw.jediSetting();
				while(it.hasNext()){
					Rebels rebel = it.next();
					if(!rebel.isCaptive())
					System.out.println(rebel.getName() + " " + rebel.getXPos() + " " + rebel.getYPos() + " " + rebel.getState() + " " + rebel.getPoints());
				}
			}
		}
		
		/**
		 * it will list all the active stormtroopers;
		 * if there isn't a map, it will print system message;
		 * if the number of active stormtroopers is zero, it will print a system message;
		 * otherwise it will all the active stormtroopers, by order of creation;
		 * 
		 * @param rw uses methods from the class RebelWars;
		 */
		private static void listStormtroopers(RebelWars rw) {
			// TODO Auto-generated method stub
			if(!rw.hasRogueOne()){
				System.out.println(MAZE_UNDEFINED);
			}else if(rw.numOfActiveStormtroopers() == 0){
				System.out.println(NOTHING_TO_LIST);
			}else{
				System.out.println("Stormtroopers:");
				Iterator<Stormtrooper> it = rw.sithSetting();
				while(it.hasNext()){
					Stormtrooper str = it.next();
					if(!str.isCaptive())
					System.out.println(str.getIdentifier() + " " + str.getXPos() + " " + str.getYPos() + " " + str.getState());
				}
			}
		}
		
		/**
		 * it will list the path travelled by a rebel;
		 * the user will insert the name of the rebel;
		 * if the game hasn't started, it will print a system message;
		 * if the rebel with the typed name doesn't exist, it will print a system message;
		 * otherwise it will say many steps it took, and the coordinates; 
		 * 
		 * @param in input by the user;
		 * @param rw uses methods from the class RebelWars;
		 */
		private static void jediPath(Scanner in, RebelWars rw) {
			// TODO Auto-generated method stub
			String name = in.next();
			if(rw.hasSetup() && !rw.hasStarted()){
				System.out.println(GAME_NOT_STARTED);
			}else if(!rw.twoJedis(name)){
				System.out.println(REBEL_NOT_EXISTENT);
			}else{
				System.out.println("Rebel " + name + " has taken " + rw.getCoorCount(name) + " steps and is " + rw.getState(name) + ":");
				Iterator<Coordenates> it = rw.jediPath(name);
				while(it.hasNext()){
					Coordenates coordenate = it.next();
					System.out.println(coordenate.getXPos() + " " + coordenate.getYPos());
				}
			}
		}
		
		/**
		 * it will list all the captured rebels by a stormtrooper;
		 * the user will insert the stormtrooper identifier;
		 * if the game hasn't started, it will print a system message;
		 * if the stormtrooper with the typed identifier doesn't exist, it will print a system message;
		 * otherwise it will print the name of captured rebels and its last coordinates; 
		 * 
		 * @param in input by the user;
		 * @param rw uses methods from the class RebelWars;
		 */
		private static void showPrisoners(Scanner in, RebelWars rw) {
			// TODO Auto-generated method stub
			String Identifier = in.next();
			if(rw.hasSetup() && !rw.hasStarted()){
				System.out.println(GAME_NOT_STARTED);
			}else if(!rw.hasStormtrooper(Identifier)){
				System.out.println(STPER_NOT_EXISTENT);
			}else{
				System.out.println("Stormtrooper " + Identifier + " has captured " + rw.numOfCapturedRebels(Identifier) + " rebels and is " + rw.getStormtrooperState(Identifier) + ":");
				Iterator<Rebels> it = rw.capturedJedis(Identifier);
				while(it.hasNext()){
					Rebels rebel = it.next();
					System.out.println(rebel.getName() + " " + rebel.getXPos() + " " + rebel.getYPos());
				}
			}
		}
		
		/**
		 * this operation will reset the game;
		 * the user will be able to start all over again;
		 * 
		 * @param rw uses methods from the class RebelWars;
		 */
		private static void resetGame(RebelWars rw) {
			// TODO Auto-generated method stub
			rw.reset();
			System.out.println(GAME_RESTARTED);
		}
		
		/**
		 * the user inserts an option and that option will mean an operation;
		 * 
		 * @param in input by the user;
		 * @return returns the command;
		 */
		private static String getCommand(Scanner in) {
			String input;
			input = in.next().toUpperCase();
			return input;
		}
}

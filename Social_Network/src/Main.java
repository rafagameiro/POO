/**
 * 
 */
import dataBase.Iteratorclass;
import dataBase.Personclass;
import dataBase.Social_Networkclass;
import java.util.Scanner;
/**
 * @author Rafael Gameiro
 *
 */
public class Main {
	
	public static final String SEARCH_PERSON = "CONSULTAPESSOA";
	public static final String SIGN_UP = "REGISTA";
	public static final String CHECK_FRIENDSHIP = "CONSULTAAMIZADE";
	public static final String NEW_FRIENDS = "AMIGOS";
	public static final String NUMOFFRIENDS = "CONSULTAAMIGOS";
	public static final String STATUS = "NOVOESTADO";
	public static final String CHECK_STATUS = "CONSULTAESTADO";
	public static final String USERNAMES = "PESSOAS";
	public static final String LEAVE = "SAIR";
	public static final String ENROLLED = "Pessoa registada.";
	public static final String HASNT_ENROLLED = "Sem registo.";
	public static final String ENROLL_SUCESS = "Pessoa registada com sucesso.";
	public static final String ALREADY_ENROLLED = "Pessoa registada.";
	public static final String FRIENDSHIP_YES = "Amizade existente.";
	public static final String FRIENDSHIP_NO = "Amizade inexistente.";
	public static final String NEW_FRIENDSHIP = "Amizade criada.";
	public static final String INVALID_FRIENDSHIP = "Amizade invalida.";
	public static final String NEW_STATUS = "Estado alterado.";
	public static final String SN_EMPTY = "Rede Social vazia.";
	public static final String SN_ACTIVE = "Lista de pessoas registadas:";
	public static final String GOODBYE = "Adeus.";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Social_Networkclass sn = new Social_Networkclass();
		String option = "";
		
		while(!option.equals(LEAVE)){
			option = in.nextLine().toUpperCase();
			switch(option){
			case SEARCH_PERSON:hasUser(in, sn);
				break;
			case SIGN_UP:addUser(in, sn);
				break;
			case CHECK_FRIENDSHIP:areFriends(in,sn);
				break;
			case NEW_FRIENDS:addFriend(in,sn);
				break;
			case NUMOFFRIENDS:numOfFriends(in,sn);
				break;
			case STATUS:newStatus(in,sn);
				break;
			case CHECK_STATUS:tellStatus(in,sn);
				break;
			case USERNAMES:registedUsers(sn);
				break;
			case LEAVE: System.out.println(GOODBYE);	
				break;
			}
			System.out.println();
		}
		
		in.close();

	}

	private static void hasUser(Scanner in, Social_Networkclass sn) {
		// TODO Auto-generated method stub
		String name = in.nextLine();
		if(sn.hasUser(name)){
			System.out.println(ENROLLED);
		}else{
			System.out.println(HASNT_ENROLLED);
		}
	}

	private static void addUser(Scanner in, Social_Networkclass sn) {
		// TODO Auto-generated method stub
		String name = in.nextLine();
		String status = in.nextLine();
		if(sn.hasUser(name)){
			System.out.println(ALREADY_ENROLLED);
		}else{
			sn.addUser(name, status);
			System.out.println(ENROLL_SUCESS);
		}
	}

	private static void areFriends(Scanner in, Social_Networkclass sn) {
		// TODO Auto-generated method stub
		String name = in.nextLine();
		String name2 = in.nextLine();
		if(!sn.hasUser(name) || !sn.hasUser(name2)){
			System.out.println(FRIENDSHIP_NO);
		}
		else if(sn.areFriends(name, name2)){
			System.out.println(FRIENDSHIP_YES);
		}else{
			System.out.println(FRIENDSHIP_NO);
		}
	}

	private static void addFriend(Scanner in, Social_Networkclass sn) {
		// TODO Auto-generated method stub
		String name = in.nextLine();
		String name2 = in.nextLine();
		if(!sn.hasUser(name) || !sn.hasUser(name2)){
			System.out.println(HASNT_ENROLLED);
		}else if(name.equalsIgnoreCase(name2)){
			System.out.println(INVALID_FRIENDSHIP);
		}else if(sn.areFriends(name, name2)){
			System.out.println(FRIENDSHIP_YES);
		}else{
			sn.addFriends(name, name2);
			System.out.println(NEW_FRIENDSHIP);
		}
	}

	private static void numOfFriends(Scanner in, Social_Networkclass sn) {
		// TODO Auto-generated method stub
		String name = in.nextLine();
		if(sn.hasUser(name)){
			int friends = sn.howManyFriends(name);
			if(friends == 1){
				System.out.println("Tem " + friends + " amigo.");
			}else{
				System.out.println("Tem " + friends + " amigos.");
			}
		}else{
			System.out.println(HASNT_ENROLLED);
		}
		
	}

	private static void newStatus(Scanner in, Social_Networkclass sn) {
		// TODO Auto-generated method stub
		String name = in.nextLine();
		String status = in.nextLine();
		if(sn.hasUser(name)){
			sn.changeState(name, status);
			System.out.println(NEW_STATUS);
		}else{
			System.out.println(HASNT_ENROLLED);
		}
	}

	private static void tellStatus(Scanner in, Social_Networkclass sn) {
		// TODO Auto-generated method stub
		String name = in.nextLine();
		if(sn.hasUser(name)){
			System.out.println(sn.State(name));
		}else{
			System.out.println(HASNT_ENROLLED);
		}
	}

	private static void registedUsers(Social_Networkclass sn) {
		// TODO Auto-generated method stub
		if(sn.numOfUsers() != 0){
			Personclass person;
			Iteratorclass it = sn.Usernames();
			it.initializeIterator();
			System.out.println(SN_ACTIVE);
			while(it.hasNext()){
				person = it.Next();
				System.out.println(person.getName());
			}
		}else{
			System.out.println(SN_EMPTY);
		}
	}



}

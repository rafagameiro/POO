import java.util.InputMismatchException;
import java.util.Scanner;

import cbook.ContactAlreadyExistsException;
import cbook.ContactBook;
import cbook.ContactBookClass;
import cbook.Iterator;
import cbook.NoneContactException;

public class Main {
	//Constantes que definem os comandos
	 public static final String ADD_CONTACT    = "AC";
	 public static final String REMOVE_CONTACT = "RC";
	 public static final String GET_PHONE      = "GP";
	 public static final String GET_EMAIL      = "GE";
	 public static final String SET_PHONE      = "SP";
	 public static final String SET_EMAIL      = "SE";
	 public static final String LIST_CONTACTS  = "LC";
	 public static final String QUIT           = "Q";
	 
	 //Constantes que definem as mensagens para o utilizador
	 public static final String CONTACT_EXISTS = "Contact already exists.";
	 public static final String NAME_NOT_EXIST = "Contact does not exist.";
	 public static final String CONTACT_ADDED = "Contact added.";
	 public static final String CONTACT_REMOVED = "Contact removed.";
	 public static final String CONTACT_UPDATED = "Contact updated.";
	 public static final String BOOK_EMPTY = "Contact book empty.";
	 public static final String INVALID_NUMBER = "Not a valid phone number.";
	
	 public static void main(String[] args) {   
		 Scanner in = new Scanner(System.in);
		 ContactBook cBook = new ContactBookClass();
		 String comm = getCommand(in);
	  
		 while (!comm.equals(QUIT)){
			 switch (comm) {
			 case ADD_CONTACT: 
				 addContact(in,cBook);
				 break;
			 case REMOVE_CONTACT:
				 deleteContact(in,cBook);
				 break;
			 case GET_PHONE:
				 getPhone(in,cBook);
				 break;
			 case GET_EMAIL: 
				 getEmail(in,cBook);
				 break;
			 case SET_PHONE:
				 setPhone(in,cBook);
				 break;
			 case SET_EMAIL:
				 setEmail(in,cBook);
				 break;
			 case LIST_CONTACTS:
				 listAllContacts(cBook);
				 break;
			 default:
				 System.out.println("ERRO");
			 }
			 System.out.println();
			 comm = getCommand(in);
		 }
		 System.out.println("Goodbye!");
		 System.out.println();
		 in.close();
	 }
	
	private static String getCommand(Scanner in) {
		String input;
		input = in.nextLine().toUpperCase();
		return input;
	}

	private static void addContact(Scanner in, ContactBook cBook){
		String name, email;
		int phone;
		try {
				name = in.nextLine();
				phone = in.nextInt(); in.nextLine();
				email = in.nextLine(); 

				try{
				cBook.addContact(name, phone, email);
				System.out.println(CONTACT_ADDED);
				}catch(ContactAlreadyExistsException e){
					System.out.println(CONTACT_EXISTS);
				}
				
		} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
			in.nextLine();
			in.nextLine();
			System.out.println(INVALID_NUMBER);
		}
		
	}

	private static void deleteContact(Scanner in, ContactBook cBook) {
		String name;
		name = in.nextLine();
			try{
			cBook.deleteContact(name);
			System.out.println(CONTACT_REMOVED);
			}catch(NoneContactException e){
				System.out.println(NAME_NOT_EXIST);
			}
	}
	
	private static void getPhone(Scanner in, ContactBook cBook) {
		String name;
		name = in.nextLine();
		if (cBook.hasContact(name)) {
			System.out.println(cBook.getPhone(name));
		}
		else System.out.println(NAME_NOT_EXIST);
	}
	
	private static void getEmail(Scanner in, ContactBook cBook) {
		String name;
		name = in.nextLine();
		if (cBook.hasContact(name)) {
			System.out.println(cBook.getEmail(name));
		}
		else System.out.println(NAME_NOT_EXIST);
	}
	
	private static void setPhone(Scanner in, ContactBook cBook) {
		String name;
		int phone;
		
		try{
		name = in.nextLine();
		phone = in.nextInt(); in.nextLine();
		if (cBook.hasContact(name)) {
			cBook.setPhone(name,phone);
			System.out.println(CONTACT_UPDATED);
		}
		else System.out.println(NAME_NOT_EXIST);
		
		}catch(InputMismatchException e){
			in.nextLine();
			System.out.println(INVALID_NUMBER);
		}
	}
	
	private static void setEmail(Scanner in, ContactBook cBook) {
		String name;
		String email;
		name = in.nextLine();
		email = in.nextLine();
		if (cBook.hasContact(name)) {
			cBook.setEmail(name,email);
			System.out.println(CONTACT_UPDATED);
		}
		else System.out.println(NAME_NOT_EXIST);
	}

	private static void listAllContacts(ContactBook cBook) {
		if (cBook.getNumberOfContacts() != 0) {
			Iterator it = cBook.listContacts();
			while(it.hasNext()) 
				System.out.println(it.next());
		}
		else System.out.println(BOOK_EMPTY);
	}
}

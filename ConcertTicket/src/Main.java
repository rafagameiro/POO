/**
 * 
 */

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import artists.*;
import database.*;
import exceptions.*;
import shows.*;
import tickets.*;
import users.NormalUser;

public class Main {
	

	public static final String LIST_SHOWS = "SHOWS";
	public static final String LIST_SHOWS_BY_CLIENTS = "SHOWSBYCLIENTS";
	public static final String LIST_SHOWS_BY_TYPE = "SHOWSBYTYPE";
	public static final String SHOW_INFO = "SHOW";
	public static final String SEARCH_BY_ARTIST = "SEARCH";
	public static final String ADD_USER = "REGISTER";
	public static final String EXIT = "EXIT";
	

	public static final String ADD_ARTIST_BAND = "ADDARTIST";
	public static final String ADD_SHOW = "ADDSHOW";
	

	public static final String BUY_TICKET = "BUYTICKET";
	public static final String LIST_MY_TICKETS = "MYTICKETS";
	

	public static final String LOGIN = "LOGIN";
	public static final String LOGOUT = "LOGOUT";
	
	
	public static final String CONCERT = "CONCERT";
	public static final String FESTIVAL = "FESTIVAL";

	public static final String LIST_ALL_SHOWS = "All shows:";
	public static final String LIST_MOST_SOLD_SHOWS = "Most sold shows:";
	public static final String LIST_CONCERTS = "Concerts:";
	public static final String LIST_FESTIVALS = "Festivals:";
	public static final String CONCERTS_OF = "Concerts of ";
	public static final String FESTIVALS_WHERE = "Festivals where ";
	public static final String WILL_PLAY = " will play:";
	public static final String USER_REGISTERED = "User was registered: ";
	public static final String EXITING = "Exiting.";
	public static final String ARTIST_ADDED = "Artist added.";
	public static final String SHOW_ADDED = "Show added.";	
	public static final String TICKET_COST = "Ticket bought with cost ";	
	public static final String MY_TICKETS = "My tickets:";	
	public static final String WELCOME = "Welcome ";	
	public static final String GOODBYE = "Goodbye ";
	public static final String TYPE_EVENT_QUESTION = "CONCERT OR FESTIVAL?";
	public static final String UNKNOWN_COMMAND = "Unknown command";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner (System.in);
		FindConcertTicket FCTicket = new FindConcertTicketclass();
		String command = getCommand(in);
		
		while (!command.equals(EXIT)) {
			switch (command) {
			case LIST_SHOWS: listShows(FCTicket); break;
			case LIST_SHOWS_BY_CLIENTS: listShowsByClients(FCTicket); break;
			case LIST_SHOWS_BY_TYPE: listShowsByType(in, FCTicket); break;
			case SHOW_INFO: getShowInfo(in, FCTicket); break;
			case SEARCH_BY_ARTIST: searchByArtist(in, FCTicket); break;
			case ADD_USER: addUser(in, FCTicket); break;

			case ADD_ARTIST_BAND: addArtistBand(in, FCTicket); break;
			case ADD_SHOW: addShow(in, FCTicket); break;
			
			case BUY_TICKET: buyTicket(in, FCTicket); break;
			case LIST_MY_TICKETS: listTickets(FCTicket); break;
			
			case LOGIN: loginCommand(in, FCTicket); break;
			case LOGOUT: logoutCommand(FCTicket); break;	
			default: System.out.println(UNKNOWN_COMMAND);break;
			}
			
			System.out.println();
			command = getCommand(in);
		}
		
		System.out.println(EXITING);
		System.out.println("");
		in.close();

	}
	
	private static String getCommand(Scanner in) {
		String command;
					
		command = in.nextLine().toUpperCase();
		return command;
	}
	
	private static void listShows (FindConcertTicket FCTicket) {
		Iterator<Event> it = FCTicket.listShows();
		System.out.println(LIST_ALL_SHOWS);
		while(it.hasNext()){
			Event event = it.next();
			if(event instanceof Concert){
				System.out.println(event.getNameEvent());
				System.out.println(((Concert) event).getNameArtistBand());
				System.out.println(event.getDate());
				System.out.println(((Concert) event).getpriceTicket());
				System.out.println(event.getNumberTickets());
			}else{
				int numberDays = ((Festival) event).getNumberDays();
				LocalDate date = event.getDate();
				System.out.println(event.getNameEvent());
				for(int i = 0; i < numberDays;i++){
					System.out.println(date);
					Iterator<Artists> it2 = ((Festival) event).listArtists(date);
					while(it2.hasNext()){
						System.out.println(it2.next().getName());
					}
					date = date.plusDays(1);
				}
				
				date = event.getDate();
				System.out.println(date);
				date = date.plusDays(numberDays-1);
				System.out.println(date);
				
				int num = 1;
				Iterator<Integer> it3 = ((Festival) event).listPriceTickets();
				while(it3.hasNext()){
					System.out.println(num + " " + it3.next());
					num++;
				}
				
				date = event.getDate();
				Iterator<Integer> it4 = ((Festival) event).listNumberTickets();
				while(it4.hasNext()){
					System.out.println(date + " " + it4.next());
					date = date.plusDays(1);
				}
			}
		}
	}
	
	private static void listShowsByClients (FindConcertTicket FCTicket) {
		
		try {
			System.out.println(LIST_MOST_SOLD_SHOWS);
			Iterator<Event> it = FCTicket.listByClients();
			
			while (it.hasNext()) {
				Event event = it.next();
				if(event instanceof Concert) {
					System.out.println(event.getNameEvent());
					System.out.println(((Concert) event).getNameArtistBand());
					System.out.println(event.getDate());
					System.out.println(((Concert) event).getpriceTicket());
					System.out.println(event.getNumberTickets());
				}
				else if (event instanceof Festival) {
					int numberDays = ((Festival) event).getNumberDays();
					LocalDate date = event.getDate();
					System.out.println(event.getNameEvent());
					for(int i = 0; i < numberDays;i++){
						System.out.println(date);
						Iterator<Artists> it2 = ((Festival) event).listArtists(date);
						while(it2.hasNext()){
							System.out.println(it2.next().getName());
						}
						date = date.plusDays(1);
					}
					
					date = event.getDate();
					System.out.println(date);
					date = date.plusDays(numberDays-1);
					System.out.println(date);
												
					int num = 1;
					Iterator<Integer> it3 = ((Festival) event).listPriceTickets();
					while(it3.hasNext()){
						System.out.println(num + " " + it3.next());
						num++;
					}
					
					date = event.getDate();
					Iterator<Integer> it4 = ((Festival) event).listNumberTickets();
					while(it4.hasNext()){
						System.out.println(date + " " + it4.next());
						date = date.plusDays(1);
					}
				}
			}
		}
		catch (UnknownShowException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void listShowsByType (Scanner in, FindConcertTicket FCTicket) {
		
		String typeOfShow = in.nextLine();
		
		try {
			Iterator<Event> it = FCTicket.listByType(typeOfShow);
			if(typeOfShow.equals("Concert"))
				System.out.println(LIST_CONCERTS);
			else
				System.out.println(LIST_FESTIVALS);
			
			while (it.hasNext()) {
				Event event = it.next();
				if(event instanceof Concert) {
					System.out.println(event.getNameEvent());
					System.out.println(((Concert) event).getNameArtistBand());
					System.out.println(event.getDate());
					System.out.println(((Concert) event).getpriceTicket());
					System.out.println(event.getNumberTickets());
				}
				else if (event instanceof Festival) {
					int numberDays = ((Festival) event).getNumberDays();
					LocalDate date = event.getDate();
					System.out.println(event.getNameEvent());
					for(int i = 0; i < numberDays;i++){
						System.out.println(date);
						Iterator<Artists> it2 = ((Festival) event).listArtists(date);
						while(it2.hasNext()){
							System.out.println(it2.next().getName());
						}
						date = date.plusDays(1);
					}
					
					date = event.getDate();
					System.out.println(date);
					date = date.plusDays(numberDays-1);
					System.out.println(date);
												
					int num = 1;
					Iterator<Integer> it3 = ((Festival) event).listPriceTickets();
					while(it3.hasNext()){
						System.out.println(num + " " + it3.next());
						num++;
					}
					
					date = event.getDate();
					Iterator<Integer> it4 = ((Festival) event).listNumberTickets();
					while(it4.hasNext()){
						System.out.println(date + " " + it4.next());
						date = date.plusDays(1);
					}
				}

			}
		}
		catch (UnknownShowException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void getShowInfo (Scanner in, FindConcertTicket FCTicket) {
		
		String nameShow = in.nextLine();
		String dateS = in.nextLine();
		LocalDate date = LocalDate.parse(dateS);
		
		try {
			Event event = FCTicket.getEventInfo(nameShow, date);
			System.out.println(nameShow + " on " + date + ":");
			if(event instanceof Concert){
				System.out.println(nameShow);
				System.out.println(event.getNameArtistBand());
				System.out.println(date);
				System.out.println(((Concert) event).getpriceTicket());
				System.out.println(event.getNumberTickets());
			}else{
				int numberDays = ((Festival)event).getNumberDays();
				System.out.println(nameShow);
				for(int i = 0; i < numberDays;i++){
					Iterator<Artists> it = ((Festival) event).listArtists(date);
					System.out.println(date);
					while(it.hasNext()){
						System.out.println(it.next().getName());
					}
					date = date.plusDays(1);
				}
				date = event.getDate();
				System.out.println(date);
				date = date.plusDays(numberDays-1);
				System.out.println(date);
				
				int num = 1;
				Iterator<Integer> it2 = ((Festival) event).listPriceTickets();
				while(it2.hasNext()){
					System.out.println(num + " " + it2.next());
					num++;
				}
				
				date = event.getDate();
				Iterator<Integer> it3 = ((Festival) event).listNumberTickets();
				while(it3.hasNext()){
					System.out.println(date + " " + it3.next());
					date = date.plusDays(1);
				}
				
			}			
		}
		catch (DoNotExistException e) {
			System.out.println(e.getMessage());
		}
		
	}	
	
	private static void searchByArtist (Scanner in, FindConcertTicket FCTicket) {
		
		String name = in.nextLine();
		
		Iterator<Event> it = FCTicket.searchByArtist(name);
		
		System.out.println(CONCERTS_OF + name + ":");
		while (it.hasNext()) {
			Event event = it.next();
			if(event instanceof Concert) {
				System.out.println(event.getNameEvent());
				System.out.println(((Concert) event).getNameArtistBand());
				System.out.println(event.getDate());
				System.out.println(((Concert) event).getpriceTicket());
				System.out.println(event.getNumberTickets());
			}
		}
		System.out.println(FESTIVALS_WHERE + name + WILL_PLAY);
		
		it = FCTicket.searchByArtist(name);
		
		while (it.hasNext()) {
			Event event = it.next();
			if (event instanceof Festival) {
				int numberDays = ((Festival) event).getNumberDays();
				LocalDate date = event.getDate();
				System.out.println(event.getNameEvent());
				for(int i = 0; i < numberDays;i++){
					System.out.println(date);
					Iterator<Artists> it2 = ((Festival) event).listArtists(date);
					while(it2.hasNext()){
						System.out.println(it2.next().getName());
					}
					date = date.plusDays(1);
				}
				
				date = event.getDate();
				System.out.println(date);
				date = date.plusDays(numberDays-1);
				System.out.println(date);
											
				int num = 1;
				Iterator<Integer> it3 = ((Festival) event).listPriceTickets();
				while(it3.hasNext()){
					System.out.println(num + " " + it3.next());
					num++;
				}
				
				date = event.getDate();
				Iterator<Integer> it4 = ((Festival) event).listNumberTickets();
				while(it4.hasNext()){
					System.out.println(date + " " + it4.next());
					date = date.plusDays(1);
				}
			}
		}
		
	}	
	
	private static void addUser (Scanner in, FindConcertTicket FCTicket) {
		
		String type = in.nextLine();
		String email = in.nextLine();
		
		try {
			FCTicket.addUsers(type, email);
			System.out.println(USER_REGISTERED + FCTicket.getPassword(email));
		}
		catch (LoggedInException e1) {
			System.out.println(e1.getMessage());
		}
		catch (AlreadyExistException e2) {
			System.out.println(e2.getMessage());
		}
		
	}	
	
	private static void addArtistBand (Scanner in, FindConcertTicket FCTicket) {
		
		String nameArtistBand = in.nextLine();
		int numberAlbums = in.nextInt(); in.nextLine();
		String[] albums = new String[numberAlbums];
		try {
			for (int i=1; i<=numberAlbums; i++) {
				String nameAlbums = in.nextLine();
				albums[i-1] = nameAlbums;
			}
			int numberElements = in.nextInt(); in.nextLine();

			if (numberElements>1) {
				String[] members = new String[numberElements];
				for (int j=1; j<=numberElements; j++) {
					String nameElements = in.nextLine();
					members[j-1] = nameElements;
				}
				FCTicket.addBand(nameArtistBand, numberElements, albums, members);
			}else{
				FCTicket.addSinger(nameArtistBand, albums);
			}
			System.out.println(ARTIST_ADDED);
		}
		catch (InvalidCommandForUserException e1) {
			System.out.println(e1.getMessage());
		}
		catch (AlreadyExistException e2) {
			System.out.println(e2.getMessage());
		}
		
	}	
	
	private static void addShow (Scanner in, FindConcertTicket FCTicket) {
			
			String nameEvent = in.nextLine();
			String description = in.nextLine();
			int numberTickets = in.nextInt(); in.nextLine();
			
			try {
				System.out.println(TYPE_EVENT_QUESTION);
				String typeEvent = in.nextLine().toUpperCase();
				if (typeEvent.equals(CONCERT)) {
					String nameArtist = in.nextLine();
					String dateS = in.nextLine();
					LocalDate date = LocalDate.parse(dateS);
					int priceTicket = in.nextInt(); in.nextLine();
					
					FCTicket.addConcert(nameEvent, description, numberTickets, nameArtist, date, priceTicket);
					System.out.println(SHOW_ADDED);
				}
				else if (typeEvent.equals(FESTIVAL)) {
					int numberDays = in.nextInt(); in.nextLine();
					String dateS = in.nextLine();
					LocalDate date = LocalDate.parse(dateS);
					int numberArtists = 0;
					String nameArtist = null;
					int pricePosition = 0;
					int priceTicket = 0;
					String[] artistsPerDay;
					List<String[]> collectionArtists = new ArrayList<String[]>(numberDays);
					List<Integer> pricePerDay = new ArrayList<Integer>(numberDays);
					
					for (int i=1; i<=numberDays; i++) {
						numberArtists = in.nextInt(); in.nextLine();
						artistsPerDay = new String[numberArtists];
						for (int j=1; j<=numberArtists; j++) {
							nameArtist = in.nextLine();
							artistsPerDay[j-1] = nameArtist;
						}
						collectionArtists.add(artistsPerDay);			
					}
					
					for (int k=1; k<=numberDays; k++) {
						pricePosition = in.nextInt();
						priceTicket = in.nextInt(); in.nextLine();
						pricePerDay.add(pricePosition-1, priceTicket);
					}
					
					FCTicket.addFestival(nameEvent, description, numberTickets, numberDays, date, numberArtists, collectionArtists, pricePerDay);
					System.out.println(SHOW_ADDED);
				}		
	
			}
			catch (InvalidCommandForUserException e1) {
				System.out.println(e1.getMessage());
			}
			catch (AlreadyExistException e2) {
				System.out.println(e2.getMessage());
			}
			catch (DoNotExistException e3) {
				System.out.println(e3.getMessage());
				Iterator<String> it = e3.listInexistents();
				while(it.hasNext()){
					System.out.println(it.next());
				}
			}
			
		}

	private static void buyTicket (Scanner in, FindConcertTicket FCTicket) {
			
			String name = in.nextLine();
			String dateS = in.nextLine();
			LocalDate date = LocalDate.parse(dateS);
			
			try {
				System.out.println(TYPE_EVENT_QUESTION);
				String typeEvent = in.nextLine().toUpperCase();
				if (typeEvent.equals(CONCERT)) {
					int numberPeople = in.nextInt(); in.nextLine();
				
					System.out.println(TICKET_COST + FCTicket.buyConcertTicket(name, date, numberPeople) + ".");
				}
				else if (typeEvent.equals(FESTIVAL)) {
					int numberDays = in.nextInt(); in.nextLine();
					LocalDate[] collectionDays = new LocalDate[numberDays];
					for (int i=1; i<=numberDays; i++) {
						String dateTicketS = in.nextLine();
						LocalDate dateTicket = LocalDate.parse(dateTicketS);
						collectionDays[i-1] = dateTicket;
					}
					System.out.println(TICKET_COST + FCTicket.buyFestivalTicket(name, date, numberDays, collectionDays) + ".");
				}
			}
			catch (InvalidCommandForUserException e1) {
				System.out.println(e1.getMessage());
			}
			catch (DoNotExistException e2) {
				System.out.println(e2.getMessage());
			}
			catch (InsufficientSeatsException e3) {
				System.out.println(e3.getMessage());
			}
			
		}

	private static void listTickets (FindConcertTicket FCTicket) {
		
		NormalUser user = FCTicket.getUserTickets();
		System.out.println(MY_TICKETS);
		Iterator<Tickets> it = user.listTickets(CONCERT);
		while(it.hasNext()){
			Tickets ticket = it.next();
			System.out.println(ticket.getNameEvent());
			System.out.println(((ConcertTickets)ticket).getDate());
			System.out.println(((ConcertTickets)ticket).getNumberPeople());
			System.out.println(ticket.getPrice());
		}
		it = user.listTickets(FESTIVAL);
		while(it.hasNext()){
			Tickets ticket = it.next();
			System.out.println(ticket.getNameEvent());
			Iterator<LocalDate> it2 = ((FestivalTickets) ticket).getDaysOfEvent();
			while(it2.hasNext()){
				System.out.println(it2.next());
			}
			System.out.println(ticket.getPrice());
		}
		
	}

	private static void loginCommand (Scanner in, FindConcertTicket FCTicket) {
		
		String email = in.nextLine();
		String password = in.nextLine();
		
		try {
			FCTicket.logIn(email, password);
			System.out.println(WELCOME + email);
		}
		catch (DoNotExistException e1) {
			System.out.println(e1.getMessage());
		}
		catch (LoggedInException e2) {
			System.out.println(e2.getMessage());
		}
		catch (WrongPasswordException e3) {
			System.out.println(e3.getMessage());
		}
		
	}

	private static void logoutCommand (FindConcertTicket FCTicket) {

		try {
			System.out.println(GOODBYE + FCTicket.logOut());
		}
		catch (LoggedInException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}

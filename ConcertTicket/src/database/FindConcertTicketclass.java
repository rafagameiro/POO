/**
 * 
 */
package database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Comparators.*;
import artists.*;
import exceptions.*;
import iterators.*;
import shows.*;
import tickets.*;
import users.*;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public class FindConcertTicketclass implements FindConcertTicket {
	
	static final String ADMIN = "admin";
	
	
	private Map<String, Users> users;
	private Map<String, Artists> artists;
	private List<Event> events;
	private boolean isLogged;
	private String currentUser;
	private int numberAdmin;
	private int numberNormal;
	
	
	public FindConcertTicketclass(){
		users = new HashMap<String,Users>();
		artists = new HashMap<String,Artists>();
		events = new ArrayList<Event>();
		isLogged = false;
		currentUser = "";
		numberAdmin = 1;
		numberNormal = 1;
	}


	@Override
	public void addUsers(String type, String name) throws AlreadyExistException, LoggedInException {
		// TODO Auto-generated method stub
		if(isLogged)
			throw new LoggedInException("User already logged in.");
		else if(users.containsKey(name))
			throw new AlreadyExistException("User");
		else{
			if(type.equalsIgnoreCase(ADMIN)){
				users.put(name, new Adminclass(name,numberAdmin++));
			}else{
				users.put(name, new NormalUserclass(name,numberNormal++));
			}
		}
	}
	
	@Override
	public String getPassword(String name) {
		// TODO Auto-generated method stub
		String password;
		if(users.get(name) instanceof Adminclass){
			Admin admin = (Admin) users.get(name);
			password = admin.getPassword();
		}else{
			NormalUser user = (NormalUser) users.get(name);
			password = user.getPassword();
		}
		return password;
	}

	@Override
	public void logIn(String name, String password) throws DoNotExistException, LoggedInException, WrongPasswordException {
		// TODO Auto-generated method stub
		if(!users.containsKey(name))
			throw new DoNotExistException("User does not exist.");
		else if(isLogged && currentUser.equalsIgnoreCase(name))
			throw new LoggedInException("User already logged in.");
		else if(isLogged && !currentUser.equalsIgnoreCase(name))
			throw new LoggedInException("Another user is logged in.");
		else if(!users.get(name).samePassword(password))
			throw new WrongPasswordException();
		else{
			isLogged = true;
			currentUser = name;
		}
	}


	@Override
	public String logOut() throws LoggedInException {
		// TODO Auto-generated method stub
		if(!isLogged)
			throw new LoggedInException("No user is logged in.");
		else{
			Users user = users.get(currentUser);
			isLogged = false;
			currentUser = "";
			return user.getName();
		}
	}


	@Override
	public void addBand(String nameBand, int numberMembers, String[] albums, String[] members)
			throws InvalidCommandForUserException, AlreadyExistException {
		// TODO Auto-generated method stub
		if(!(isLogged && users.get(currentUser) instanceof Adminclass))
			throw new InvalidCommandForUserException();
		else if(artists.containsKey(nameBand))
			throw new AlreadyExistException("Artist name");
		else{
			Band band = new Bandclass(nameBand,numberMembers);
			for(int i = 0; i < albums.length;i++)
				band.addAlbum(albums[i]);
			
			for(int j = 0; j < numberMembers;j++)
				band.addMember(members[j]);
			
			artists.put(nameBand, band);
		}
	}


	@Override
	public void addSinger(String nameBand, String[] albums) throws InvalidCommandForUserException, AlreadyExistException {
		// TODO Auto-generated method stub
		if(!(isLogged && users.get(currentUser) instanceof Adminclass))
			throw new InvalidCommandForUserException();
		else if(artists.containsKey(nameBand))
			throw new AlreadyExistException("Artist name");
		else{
			Singer singer = new Singerclass(nameBand);
			for(int i = 0; i < albums.length;i++)
				singer.addAlbum(albums[i]);
			
			artists.put(nameBand, singer);
		}
	}
	
	@Override
	public void addConcert (String nameEvent, String description, int numberTickets, String nameArtistBand, LocalDate date, int priceTicket) throws AlreadyExistException, InvalidCommandForUserException, DoNotExistException {
		if(!(isLogged && users.get(currentUser) instanceof Adminclass))
			throw new InvalidCommandForUserException();
		else if (searchForEvent(nameEvent, date)!=null)
			throw new AlreadyExistException("Show");
		else if (!artists.containsKey(nameArtistBand)) {
			List<String> inexistentArtist = new LinkedList<String>();
			inexistentArtist.add(nameArtistBand);
			throw new DoNotExistException(inexistentArtist);
		}
		else {		
			Concert concert = new Concertclass(nameEvent, description, "Concert",numberTickets, nameArtistBand, date, priceTicket);
			events.add(concert);
	    }
	}
	
	@Override
	public void addFestival (String nameEvent, String description, int numberTickets, int numberDays, LocalDate date, int numberArtists, List<String[]> collectionArtists, List<Integer> pricePerDay) throws AlreadyExistException, InvalidCommandForUserException, DoNotExistException {
		if(!(isLogged && users.get(currentUser) instanceof Adminclass))
			throw new InvalidCommandForUserException();
		else if (searchForEvent(nameEvent, date)!=null)
			throw new AlreadyExistException("Show");
		else if (areAllArtists(collectionArtists)!=null)
			throw new DoNotExistException(areAllArtists(collectionArtists));
		else {	
			Festival festival = new Festivalclass(nameEvent, description, "Festival", numberTickets, numberDays, date, numberArtists, pricePerDay);
			for (int i=0; i<collectionArtists.size(); i++) {
				LinkedList<Artists> artists = addArtists(collectionArtists, i);
				festival.addArtistsPerDay(date, artists);
				date = date.plusDays(1);
			}
			events.add(festival);
		 }
	}
	
	@Override
	public int buyConcertTicket(String nameShow, LocalDate date, int numberTickets) throws InvalidCommandForUserException, DoNotExistException, InsufficientSeatsException {
		if(!(isLogged && users.get(currentUser) instanceof NormalUserclass))
			throw new InvalidCommandForUserException();
		else if(searchForEvent(nameShow, date)==null)
			throw new DoNotExistException("Show does not exist.");
		else if(events.get(searchIndexOfEvent(nameShow)).getNumberTickets()<numberTickets)
			throw new InsufficientSeatsException();
		else {
			NormalUser user = (NormalUser) users.get(currentUser);
			Concert concerts = (Concert) events.get(searchIndexOfEvent(nameShow));
			int totalPrice = concerts.getpriceTicket()*numberTickets;
			user.addTicket(new ConcertTicketsclass(nameShow, numberTickets, date, totalPrice));
			
			for (int i=1; i<=numberTickets; i++) {
				concerts.setNumberOfTicketsSold();
				concerts.setNumberTickets();
			}
			
			return totalPrice;	
		}
	}
	
	@Override
	public int buyFestivalTicket(String nameShow, LocalDate date, int numberDays, LocalDate[] dates) throws InvalidCommandForUserException, DoNotExistException, InsufficientSeatsException {
		
		if(!(isLogged && users.get(currentUser) instanceof NormalUserclass))
			throw new InvalidCommandForUserException();
		else if(searchForEvent(nameShow, date)==null)
			throw new DoNotExistException("Show does not exist.");
		else if(!checkFestivalTickets(dates,numberDays,date,((Festival)searchForEvent(nameShow,date))))
			throw new InsufficientSeatsException();
		else {
			NormalUser user = (NormalUser) users.get(currentUser);
			Festival festivals = (Festival) events.get(searchIndexOfEvent(nameShow));
			int totalPrice = festivals.getpriceTicket(numberDays-1);
			user.addTicket(new FestivalTicketsclass(nameShow, totalPrice, dates));
			
			LocalDate dateTemp = date;
			for (int i=0; i<numberDays; i++) {
				dateTemp = date;
				for (int j=1; j<=festivals.getNumberDays(); j++) {
					if (dates[i].compareTo(dateTemp) == 0) {
						festivals.setNumberOfTicketsSold();
						festivals.setNumberTicketsPerDay(j);
					}
					dateTemp = dateTemp.plusDays(1);					
				}	
			}	
			
			return totalPrice;	
		}
	}
	
	private boolean checkFestivalTickets(LocalDate[] dates, int numberDays, LocalDate date, Festival festival) {
		// TODO Auto-generated method stub
		int istrue = 0;
		LocalDate dateTest = date;
		for(int i = 0; i < numberDays;i++){
			dateTest = date;
			for(int j = 1; j <= festival.getNumberDays();j++){
				if(dateTest.compareTo(dates[i]) == 0){
					if(festival.getNumberTicketsPerDay(j) > 0)
						istrue++;
				}
				dateTest = dateTest.plusDays(1);
			}
		}
		if(istrue == numberDays)
			return true;
		else
			return false;
	}


	@Override
	public Event getEventInfo(String nameShow, LocalDate date) throws DoNotExistException{
		// TODO Auto-generated method stub
		if(searchForEvent(nameShow,date) == null)
			throw new DoNotExistException("Show does not exist.");
		return searchForEvent(nameShow,date);
	}
	
	@Override
	public NormalUser getUserTickets() {
		// TODO Auto-generated method stub
		NormalUser user = (NormalUser) users.get(currentUser);
		return user;
	}	

	@Override
	public Iterator<Event> listShows() {
		// TODO Auto-generated method stub
		return events.iterator();
	}
	
	@Override
	public Iterator<Event> searchByArtist(String nameArtist) {
		
		List<Event> artistApperances = new LinkedList<Event>();
		
		for (Event e : events) {
			if (e instanceof Concert) {
					if(((Concert) e).getNameArtistBand().equalsIgnoreCase(nameArtist))
						artistApperances.add(e);
			}
			else if (e instanceof Festival) {
				LocalDate date = e.getDate();
				for (int i=0; i<((Festival) e).getNumberDays(); i++) {
					Iterator<Artists> it = ((Festival) e).listArtists(date);
					while (it.hasNext()) {
						Artists artist = it.next();
						if (artist.getName().equalsIgnoreCase(nameArtist)) {
							artistApperances.add(e);
						}
					}
					date = date.plusDays(1);
				}
			}				
		}
		return artistApperances.iterator();		
	}

	@Override
	public Iterator<Event> listByType(String type) throws UnknownShowException {
		// TODO Auto-generated method stub
		if(!(type.equalsIgnoreCase("Concert") || type.equalsIgnoreCase("Festival")))
			throw new UnknownShowException();
		else{
			List<Event> eventTemp = events;
			CompareByDate c = new CompareByDate();
			eventTemp.sort(c);
			return new IteratorByType(eventTemp,type);
		}
	}
	
	@Override
	public Iterator<Event> listByClients() throws UnknownShowException {
		// TODO Auto-generated method stub
		CompareByClient c = new CompareByClient();
		List<Event> eventsTemp = events;
		eventsTemp.sort(c);
		
		return eventsTemp.iterator();
	}
	
	
	private List<String> areAllArtists(List<String[]> collectionArtists) {
			
		List<String> inexistentArtist = new LinkedList<String>();
		
		for (String[] e : collectionArtists) {
			for(int i=0; i<e.length; i++) {			
				if (!artists.containsKey(e[i]))
					inexistentArtist.add(e[i]);
			}
		}
			
		if (inexistentArtist.isEmpty())
			return null;
		else
			return inexistentArtist;
	}
	
	private LinkedList<Artists> addArtists(List<String[]> collectionArtists, int i) {
		LinkedList<Artists> artistsTemp = new LinkedList<Artists>();
				
		String[] nameArtists = collectionArtists.get(i);
		for (int j=0; j<nameArtists.length; j++){
			artistsTemp.add(artists.get(nameArtists[j]));
		}
		return artistsTemp;
	}
	
	private int searchIndexOfEvent(String nameShow) {
		int i = 0;
		int position = 0;
		boolean found = false;
		
		while (i<=events.size() && !found) {
			if (events.get(i).getNameEvent().equals(nameShow))
				found = true;
			else
				i++;					
		}
		if (found) position = i;
		
		return position;
	}	
	

	private Event searchForEvent(String nameShow, LocalDate date) {
		for (Event e : events) {
			if (e.getDate().equals(date) && e.getNameEvent().equals(nameShow))
				return e;
		}
		return null;
	}
	

}

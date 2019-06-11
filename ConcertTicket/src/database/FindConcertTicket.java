package database;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import exceptions.*;
import shows.*;
import users.*;

public interface FindConcertTicket {
	
	void addUsers(String type, String name) throws AlreadyExistException, LoggedInException;
	
	String getPassword(String name);
	
	void logIn(String name, String password) throws DoNotExistException, LoggedInException, WrongPasswordException;
	
	String logOut() throws LoggedInException; 
	
	void addBand(String nameBand, int numberMembers, String[] albums, String[] members) 
			throws InvalidCommandForUserException, AlreadyExistException;
	
	void addSinger(String nameBand, String[] albums) throws InvalidCommandForUserException, AlreadyExistException;
	
	void addConcert(String nameEvent, String description, int numberTickets, String nameArtist, LocalDate date, int priceTicket)
			throws AlreadyExistException, InvalidCommandForUserException, DoNotExistException;

	void addFestival(String nameEvent, String description, int numberTickets, int numberDays, LocalDate date, int numberArtists, List<String[]> collectionArtists, List<Integer> pricePerDay)
			throws AlreadyExistException, InvalidCommandForUserException, DoNotExistException;
	
	int buyConcertTicket(String nameShow, LocalDate date, int numberTickets) 
			throws InvalidCommandForUserException, DoNotExistException, InsufficientSeatsException;

	int buyFestivalTicket(String nameShow, LocalDate date, int numberDays, LocalDate[] dates) 
			throws InvalidCommandForUserException, DoNotExistException, InsufficientSeatsException;
	
	Event getEventInfo(String nameShow, LocalDate date) throws DoNotExistException;
	
	NormalUser getUserTickets();
	
	Iterator<Event> listShows();
	
	Iterator<Event> searchByArtist(String nameArtist);
	
	Iterator<Event> listByType(String type) throws UnknownShowException;
	
	Iterator<Event> listByClients() throws UnknownShowException;
	
	
	

}

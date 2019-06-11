/**
 * 
 */
package shows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import artists.Artists;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 * 
 *
 */
public class Festivalclass extends Eventclass implements Festival {
	
	private int numberDays;
	private int numberArtists;        
	
	private HashMap<LocalDate, LinkedList<Artists>> artistsPerDay;
	private List<Integer> priceTicket; 
	private List<Integer> numberTickets;
	
	public Festivalclass(String nameEvent, String description, String type, int numberTickets, int numberDays, LocalDate date, int numberArtist, List<Integer> pricePerDay) {
		super(nameEvent, description, numberTickets, date, type);
		this.numberDays = numberDays;
		artistsPerDay = new HashMap<LocalDate, LinkedList<Artists>>(numberDays);
		priceTicket = pricePerDay;
		this.numberTickets = new ArrayList<Integer>(numberDays);
		addNumberTickets(numberTickets);
	}
	
	private void addNumberTickets(int numberTickets) {
		// TODO Auto-generated method stub
		for(int i = 0; i < numberDays;i++){
			this.numberTickets.add(numberTickets);
		}
	}

	@Override
	public void addArtistsPerDay (LocalDate date, LinkedList<Artists> artists) {
		artistsPerDay.put(date, artists);
	}
	
	@Override
	public int getNumberDays() {
		return numberDays;
	}
	
	@Override
	public int getNumberArtistsBands() {
		return numberArtists;
	}

	@Override
	public String getNameArtistBand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getpriceTicket(int position) {
		return priceTicket.get(position);
	}
	
	@Override
	public int getNumberTicketsPerDay(int numberDays) {
		// TODO Auto-generated method stub
		return numberTickets.get(numberDays-1);
	}
	
	@Override
	public void setNumberTicketsPerDay(int numberDays) {
		// TODO Auto-generated method stub
		int numberTickets = this.numberTickets.get(numberDays-1);
		numberTickets--;
		this.numberTickets.set(numberDays-1, numberTickets);
	}

	@Override
	public Iterator<Artists> listArtists(LocalDate date) {
		// TODO Auto-generated method stub
		LinkedList<Artists> artistsDate = artistsPerDay.get(date);
		return artistsDate.iterator();
	}

	@Override
	public Iterator<Integer> listPriceTickets() {
		// TODO Auto-generated method stub
		return priceTicket.iterator();
	}

	@Override
	public Iterator<Integer> listNumberTickets() {
		// TODO Auto-generated method stub
		return numberTickets.iterator();
	}

}

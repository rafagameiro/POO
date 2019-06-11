/**
 * 
 */
package shows;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;

import artists.Artists;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public interface Festival extends Event {
	
	void addArtistsPerDay(LocalDate date, LinkedList<Artists> artists);
	
	int getpriceTicket(int position);
	
	int getNumberDays();
	
	int getNumberArtistsBands();
	
	int getNumberTicketsPerDay(int numberDays);
	
	void setNumberTicketsPerDay(int numberDays);
	
	Iterator<Artists> listArtists(LocalDate date);
	
	Iterator<Integer> listPriceTickets();
	
	Iterator<Integer> listNumberTickets();

}

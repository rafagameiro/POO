/**
 * 
 */
package shows;

import java.time.LocalDate;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public interface Event {
	
	LocalDate getDate();
	
	String getType();
	
	String getNameArtistBand();
	
	String getNameEvent();
	
	String getDescription();
	
	int getNumberOfTicketsSold();
	
	void setNumberOfTicketsSold();
	
	void setNumberTickets();
	
	int getNumberTickets();

}

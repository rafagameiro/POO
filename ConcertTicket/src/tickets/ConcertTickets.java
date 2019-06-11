/**
 * 
 */
package tickets;

import java.time.LocalDate;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public interface ConcertTickets extends Tickets {
	
	int getNumberPeople();
	
	LocalDate getDate();

}

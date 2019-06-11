/**
 * 
 */
package tickets;

import java.time.LocalDate;
import java.util.Iterator;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public interface FestivalTickets extends Tickets {
	
	Iterator<LocalDate> getDaysOfEvent();

}

/**
 * 
 */
package tickets;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public class FestivalTicketsclass extends Ticketsclass implements Tickets, FestivalTickets {
	
	private List<LocalDate> datesOfEvent;
	
	public FestivalTicketsclass(String event, int totalPrice, LocalDate[] dates) {
		super(event, totalPrice);
		datesOfEvent = new LinkedList<LocalDate>();
		getDaysOfEvent(dates);
	}
	
	private void getDaysOfEvent(LocalDate[] dates) {
		// TODO Auto-generated method stub
		for(int i = 0; i < dates.length;i++)
			datesOfEvent.add(dates[i]);
	}

	@Override
	public Iterator<LocalDate> getDaysOfEvent() {
		return datesOfEvent.iterator();
	}

}

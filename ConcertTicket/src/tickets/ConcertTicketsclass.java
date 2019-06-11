/**
 * 
 */
package tickets;

import java.time.LocalDate;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public class ConcertTicketsclass extends Ticketsclass implements Tickets, ConcertTickets {
	
	private int numberPeople;
	private LocalDate date;
	
	public ConcertTicketsclass(String event, int numberPeople, LocalDate date, int totalPrice) {
		super(event, totalPrice);
		this.numberPeople = numberPeople;
		this.date = date;
	}
	
	@Override
	public int getNumberPeople() {
		return numberPeople;
	}
	
	@Override
	public LocalDate getDate() {
		return date;
	}

}	
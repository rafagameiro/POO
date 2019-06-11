/**
 * 
 */
package iterators;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import tickets.ConcertTickets;
import tickets.Tickets;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public class IteratorByConcertTickets implements Iterator<Tickets> {
	
	
	private ListIterator<Tickets> tickets;
	/**
	 * 
	 */
	public IteratorByConcertTickets(List<Tickets> tickets) {
		// TODO Auto-generated constructor stub
		this.tickets = tickets.listIterator();
		this.searchNext();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return tickets.hasNext();
	}

	@Override
	public Tickets next() {
		// TODO Auto-generated method stub
		Tickets ticket = tickets.next();
		searchNext();
		return ticket;
	}
	
	private void searchNext(){
		while(tickets.hasNext())
			if(tickets.next() instanceof ConcertTickets){
				tickets.previous();
				return;
			}		
	}

}

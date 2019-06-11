/**
 * 
 */
package users;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import iterators.IteratorByConcertTickets;
import iterators.IteratorByFestivalTickets;
import tickets.Tickets;
import tickets.Ticketsclass;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public class NormalUserclass extends Usersclass implements NormalUser {
	
	static final String NORMAL = "client";

	private List<Tickets> tickets;
	
	public NormalUserclass(String name, int numPassword) {
		// TODO Auto-generated constructor stub
		super(name,generatePassword(numPassword));
		tickets = new LinkedList<Tickets>();
	}

	private static String generatePassword(int numPassword) {
		// TODO Auto-generated method stub
		String password;
		password = NORMAL + Integer.toString(numPassword);
		return password;
	}

	@Override
	public void addTicket(Ticketsclass ticket) {
		// TODO Auto-generated method stub
		tickets.add(ticket);
	}

	@Override
	public Iterator<Tickets> listTickets(String type) {
		// TODO Auto-generated method stub
		if(type.equalsIgnoreCase("Concert"))
			return new IteratorByConcertTickets(tickets);
		else
			return new IteratorByFestivalTickets(tickets);
	}
}

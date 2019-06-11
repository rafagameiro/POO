/**
 * 
 */
package users;

import java.util.Iterator;

import tickets.Tickets;
import tickets.Ticketsclass;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public interface NormalUser extends Users {
	
	void addTicket(Ticketsclass ticket);
	
	Iterator<Tickets> listTickets(String type);

}

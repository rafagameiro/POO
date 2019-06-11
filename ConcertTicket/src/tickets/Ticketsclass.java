/**
 * 
 */
package tickets;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public abstract class Ticketsclass implements Tickets {

	private String event;
	private int price;
	
	public Ticketsclass (String event, int price) {
		this.event = event;
		this.price = price;
	}
	
	@Override
	public String getNameEvent() {
		return event;
	}
	
	@Override
	public int getPrice() {
		return price;
	}
}

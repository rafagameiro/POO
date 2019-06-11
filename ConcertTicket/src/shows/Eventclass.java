/**
 * 
 */
package shows;

import java.time.LocalDate;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public abstract class Eventclass implements Event {
	
	private String nameEvent;
	private String description;
	private int numberTicketsTotal;
	public LocalDate date;                        
	private String type;
	private int numberTicketsSold;
	
	public Eventclass (String nameEvent, String description, int numberTicketsTotal, LocalDate date, String type) {
		this.nameEvent = nameEvent;
		this.description = description;
		this.numberTicketsTotal = numberTicketsTotal;
		this.date = date;
		this.type = type;
		numberTicketsSold = 0;
	}
	
	@Override
	public LocalDate getDate() {
		return date;
	}
	
	@Override
	public String getType() {
		return type;
	}
	
	@Override
	public String getNameEvent() {
		return nameEvent;
	}	
	
	@Override
	public String getDescription(){
		return description;
	}
	
	@Override
	public void setNumberOfTicketsSold() {
		numberTicketsSold++;
	}
	
	@Override
	public int getNumberOfTicketsSold() {
		return numberTicketsSold;
	}
	
	@Override
	public void setNumberTickets() {
		numberTicketsTotal--;
	}
	
	@Override
	public int getNumberTickets() {
		return numberTicketsTotal;
	}
	
}

/**
 * 
 */
package shows;

import java.time.LocalDate;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public class Concertclass extends Eventclass implements Concert {
	
	private String nameArtistBand;
	private int priceTicket;
	
	public Concertclass(String nameEvent, String description, String type, int numberTickets, String nameArtistBand, LocalDate date, int priceTicket) {
		super(nameEvent, description, numberTickets, date, type);
		this.nameArtistBand = nameArtistBand;
		this.priceTicket = priceTicket;
	}

	@Override
	public String getNameArtistBand() {
		// TODO Auto-generated method stub
		return nameArtistBand;
	}
	
	@Override
	public int getpriceTicket() {
		return priceTicket;
	}

}

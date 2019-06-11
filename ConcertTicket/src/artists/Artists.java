/**
 * 
 */
package artists;

import java.util.Iterator;

import shows.Event;
import shows.Eventclass;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public interface Artists {
	
	String getName();
	
	void addAlbum(String album);
	
	void addEvent(Eventclass event);
	
	Iterator<Event> listEvents();

}

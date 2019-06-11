/**
 * 
 */
package iterators;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import shows.Event;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public class IteratorByType implements Iterator<Event> {

	private ListIterator<Event> events;
	private String type;
	/**
	 * 
	 */
	public IteratorByType(List<Event> events, String type) {
		// TODO Auto-generated constructor stub
		this.events = events.listIterator();
		this.type = type;
		this.searchNext();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return events.hasNext();
	}

	@Override
	public Event next() {
		// TODO Auto-generated method stub
		Event event = events.next();
		searchNext();
		return event;
	}
	
	private void searchNext(){
		while(events.hasNext())
			if(events.next().getType().equalsIgnoreCase(type)){
				events.previous();
				return;
			}		
	}

}

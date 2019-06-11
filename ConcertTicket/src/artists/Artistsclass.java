/**
 * 
 */
package artists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import shows.Event;
import shows.Eventclass;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public abstract class Artistsclass implements Artists {
	
	private List<String> discography;
	private List<Event> concerts;
	private String name;
	
	public Artistsclass(String name){
		this.name = name;
		discography = new ArrayList<String>();
		concerts = new ArrayList<Event>();
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	@Override
	public void addAlbum(String album){
		discography.add(album);
	}
	
	@Override
	public void addEvent(Eventclass event){
		concerts.add(event);
	}
	
	@Override
	public Iterator<Event> listEvents(){
		return concerts.iterator();
	}

}

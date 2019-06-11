/**
 * 
 */
package Comparators;

import java.time.LocalDate;
import java.util.Comparator;

import shows.Event;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public class CompareByDate implements Comparator<Event> {

	@Override
	public int compare(Event show1, Event show2) {
		// TODO Auto-generated method stub
		LocalDate date1 = show1.getDate();
		LocalDate date2 = show2.getDate();
		String name1 = show1.getNameEvent();
		String name2 = show2.getNameEvent();
					
		if (date1.compareTo(date2)!=0) {
			return date1.compareTo(date2);
		}
		else {
			return name1.compareTo(name2);
		}
	}

}

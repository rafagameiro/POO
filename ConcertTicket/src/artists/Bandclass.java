/**
 * 
 */
package artists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public class Bandclass extends Artistsclass implements Band {
	
	private List<String> members;

	public Bandclass(String name,int numOfMembers) {
		// TODO Auto-generated constructor stub
		super(name);
		members = new ArrayList<String>(numOfMembers);
	}

	@Override
	public void addMember(String name) {
		// TODO Auto-generated method stub
		members.add(name);
	}

	@Override
	public Iterator<String> listMembers() {
		// TODO Auto-generated method stub
		return members.iterator();
	}
	
	

	

}

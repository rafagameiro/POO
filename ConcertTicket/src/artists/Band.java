/**
 * 
 */
package artists;

import java.util.Iterator;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public interface Band extends Artists {
	
	void addMember(String name);
	
	Iterator<String> listMembers();

}

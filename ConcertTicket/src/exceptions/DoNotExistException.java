/**
 * 
 */
package exceptions;

import java.util.Iterator;
import java.util.List;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
@SuppressWarnings("serial")
public class DoNotExistException extends Exception {

		private List<String> inexistentArtists;
		
		/**
		 * @param message
		 */
		public DoNotExistException(String e) {
			super(e);
		}
	
		public DoNotExistException(List<String> collectionArtists) {
			super("Artist name(s) do(es) not exist(s):");
			inexistentArtists = collectionArtists;
		}
		
		public Iterator<String> listInexistents(){
			return inexistentArtists.iterator();
		}
}

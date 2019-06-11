/**
 * 
 */
package users;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public class Adminclass extends Usersclass implements Admin {
	
	static final String ADMIN = "admin";

	public Adminclass(String name, int numPassword) {
		// TODO Auto-generated constructor stub
		super(name , generatePassword(numPassword));
	}

	private static String generatePassword(int numPassword) {
		// TODO Auto-generated method stub
		String password;
		password = ADMIN + Integer.toString(numPassword);
		return password;
	}
}

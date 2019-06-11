/**
 * 
 */
package users;

/**
 * @author Rafael Almeida number 49788
 * @author Rafael Gameiro number 50677
 */
public abstract class Usersclass implements Users {
	
	private String name;
	public String password;
	
	public Usersclass(String name, String password){
		this.name = name;
		this.password = password;
	}
	
	@Override
	public String getName(){
		return name;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
	@Override
	public boolean samePassword(String password) {
		// TODO Auto-generated method stub
		return this.password.equals(password);
	}
}

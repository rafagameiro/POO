/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro
 *
 */
public class Fileclass implements File {
	
	private String name;
	private int size;
	private String owner;
	
	public Fileclass(String name, int size, String owner){
		this.name = name;
		this.size = size;	
		this.owner = owner;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	@Override
	public String getOwner() {
		// TODO Auto-generated method stub
		return owner;
	}

}

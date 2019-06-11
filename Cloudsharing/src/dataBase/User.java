/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro
 *
 */
public interface User {
	
	public boolean hasFile(String file);
	
	public void addFile(String name, int size, String owner);
	
	public String getName();
	
	public String getType();
	
	public String getFileOwner(String file, String owner);
	
	public int getFreeSpace();
	
	public int getFileSize(String name, String owner);
	
	public void Init();
	
	public boolean hasNext();
	
	public Fileclass Next();
	
}

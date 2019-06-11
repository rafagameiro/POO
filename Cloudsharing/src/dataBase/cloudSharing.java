/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro
 *
 */
public class cloudSharing {
	
	private int current;
	private int counter;
	private Userabstract users[];
	
	public cloudSharing(){
		current = -1;
		counter = 0;
		users = new Userabstract[500];
	}
	
	public void addUser(String name, String type){
		if(type.equalsIgnoreCase("basic")){
			users[counter++] = new UserB(name, type);
		}else{
			users[counter++] = new UserP(name, type);
		}
	}
	
	public void addFile(String name, String file, int size, String owner){
		int pos = searchIndex(name);
		users[pos].addFile(file, size, owner);
	}
	
	public int getFreeSpace(String name){
		int pos = searchIndex(name);
		int size = users[pos].getFreeSpace();
		return size;
	}
	
	public int getFileSize(String name, String file, String owner){
		int pos = searchIndex(name);
		int size = users[pos].getFileSize(file, owner);
		return size;
	}
	
	public String getMinSpace(){
		int value = 6000;
		int pos = -1;
		for(int i = 0;i<counter;i++){
			if(users[i].getFreeSpace()<value){
				value = users[i].getFreeSpace();
				pos = i;
			}
		}
		String name = users[pos].getName();
		return name;
	}
	
	public String getUserType(String name){
		int pos = searchIndex(name);
		String type = users[pos].getType();
		return type;
	}
	
	public int getOriginalSize(String file, String owner){
		int pos = searchIndex(owner);
		int size = users[pos].getFileSize(file, owner);
		return size;
	}
	
	public boolean canShareFile(String name){
		boolean can = false;
		int pos = searchIndex(name);
		String type = users[pos].getType();
		if(type.equalsIgnoreCase("premium"))
			can = true;
		return can;
	}
	
	public void shareFile(String name, String name2, String file, String owner){
		int pos = searchIndex(name);
		int pos2 = searchIndex(name2);
		if(users[pos2].getType().equalsIgnoreCase("basic")){
			int size = (users[pos].getFileSize(file,owner)/2);
			users[pos2].addFile(file, size, users[pos].getName());
		}else{
			users[pos2].addFile(file, 0,users[pos].getName());
		}
	}
	
	public boolean hasFile(String name, String file){
		boolean has = false;
		int pos = searchIndex(name);
		if(users[pos].hasFile(file)){
			has = true;
		}
		return has;
	}
	
	public boolean hasFileOwner(String name, String name2, String file, String owner){
		boolean has = false;
		int pos = searchIndex(name2);
		if(users[pos].hasFile(file)){
			String fileOwner = users[pos].getFileOwner(file, owner);
			if(fileOwner.equalsIgnoreCase(name))
				has = true;
		}
		return has;
	}
	
	public boolean compareOwners(String name, String file, String owner){
		boolean are = false;
		int pos = searchIndex(name);
		String own = users[pos].getFileOwner(file,owner);
		if(own.equalsIgnoreCase(name)){
			are = true;
		}
		return are;
	}
	
	public boolean hasUser(String name){
		boolean has = false;
		for(int i = 0;i<counter;i++){
			if(users[i].getName().equalsIgnoreCase(name))
				has = true;
		}
		return has;
	}
	
	public int numOfAccounts(){
		return counter;
	}
	
	private int searchIndex(String name){
		int pos = 0;
		for(int i = 0;i<counter;i++){
			if(users[i].getName().equalsIgnoreCase(name)){
				pos = i;
			}
		}
		return pos;
	}
	
	public void InitFiles(String name){
		int pos = searchIndex(name);
		users[pos].Init();
	}
	
	public boolean hasNextFile(String name){
		int pos = searchIndex(name);
		boolean has = users[pos].hasNext();
		return has;
	}
	
	public Fileclass nextFile(String name){
		int pos = searchIndex(name);
		Fileclass file = users[pos].Next();
		return file;
	}
	
	public void Init(){
		current = 0;
	}
	
	public boolean hasNext(){
		return current<counter;
	}
	
	public Userabstract Next(){
		return users[current++];
	}
}

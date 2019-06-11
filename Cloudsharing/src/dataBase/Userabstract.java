/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro
 *
 */
public abstract class Userabstract implements User {
	
	public static final int DEFAULT = 200;
	
	public int size;
	public String name;
	public String type;
	Fileclass files[];
	public int countFile;
	public int currFile;
	
	public Userabstract(String name, String type, int size){
		this.name = name;
		this.type = type;
		files = new Fileclass[DEFAULT];
		this.size = size;
		countFile = 0;
		currFile = -1;
	}

	/* (non-Javadoc)
	 * @see dataBase.User#hasFile(java.lang.String)
	 */
	@Override
	public boolean hasFile(String file) {
		// TODO Auto-generated method stub
		boolean hasF = false;
		for(int i = 0;i < countFile;i++){
			if(files[i].getName().equalsIgnoreCase(file)){
				hasF = true;
			}
		}
		return hasF;
	}

	/* (non-Javadoc)
	 * @see dataBase.User#addFile(java.lang.String, java.lang.String)
	 */
	@Override
	public void addFile(String name, int size, String owner) {
		// TODO Auto-generated method stub
		if(countFile == files.length)
			resize();
		files[countFile] = new Fileclass(name,size,owner);
		countFile++;

		this.size -= size;
	}

	/* (non-Javadoc)
	 * @see dataBase.User#getName()
	 */
	@Override
	public String getName(){
		// TODO Auto-generated method stub
		return name;
	}

	/* (non-Javadoc)
	 * @see dataBase.User#getType()
	 */
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	
	/* (non-Javadoc)
	 * @see dataBase.User#getType()
	 */
	@Override
	public String getFileOwner(String file, String owner){
		int pos = indexFile(file, owner);
		String own = files[pos].getOwner();
		return own;
	}

	/* (non-Javadoc)
	 * @see dataBase.User#getFreeSpace()
	 */
	@Override
	public int getFreeSpace() {
		return size;
	}
	
	/* (non-Javadoc)
	 * @see dataBase.User#getFreeSpace()
	 */
	@Override
	public int getFileSize(String name, String owner){
		int pos = indexFile(name, owner);
		int size = files[pos].getSize();
		return size;
	}
	
	private int indexFile(String file, String owner){
		int pos = 0;
		for(int i = 0;i<countFile;i++){
			if(files[i].getName().equalsIgnoreCase(file) && files[i].getOwner().equalsIgnoreCase(owner)){
				pos = i;	
			}
		}
		return pos;
	}
	
	private void resize(){
		Fileclass fileprev[] = new Fileclass[2*files.length];
		for(int i = 0;i<countFile;i++){
			fileprev[i] = files[i];
		}
		files = fileprev;
	}
	
	/* (non-Javadoc)
	 * @see dataBase.User#hasSharedFiles()
	 */
	@Override
	public void Init(){
		currFile = 0;
	}
	
	/* (non-Javadoc)
	 * @see dataBase.User#hasSharedFiles()
	 */
	@Override
	public boolean hasNext(){
		return currFile < countFile;
	}
	
	/* (non-Javadoc)
	 * @see dataBase.User#hasSharedFiles()
	 */
	@Override
	public Fileclass Next(){
		return files[currFile++];
	}

}

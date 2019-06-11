/**
 * 
 */
package dataBase;

/**
 * @author Rafael Gameiro
 *
 */
public class UserP extends Userabstract{
	
	public static final int SIZE = 5120;
	
	public UserP(String name, String type){
		super(name, type, SIZE);
	}
//	public static final int DEFAULT = 200;
	
//	public UserP(String name, String type){
//		super.name = name;
//		super.type = type;
//		files = new Fileclass[DEFAULT];
//		super.size = SIZE;
//		super.countFile = 0;
//		super.currFile = -1;
//	}
//	
}

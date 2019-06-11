/**
 * 
 */

import java.util.Scanner;
import dataBase.cloudSharing;
import dataBase.Fileclass;
import dataBase.Userabstract;
/**
 * @author Rafael Gameiro
 *
 */
public class Main {
	
	public static final String ADD = "ADD";
	public static final String UPLOAD = "UPLOAD";
	public static final String SHARE = "SHARE";
	public static final String MINSPACE = "MINSPACE";
	public static final String LISTFILES = "LISTFILES";
	public static final String LISTALL = "LISTALL";
	public static final String LEAVE = "EXIT";
	
	public static final String ADD_SUCCESS = "Account was added.\n";
	public static final String ADD_INSUCCESS = "Account already exists.\n";
	public static final String UPLOAD_SUCCESS = "File uploaded into account.\n";
	public static final String NO_ACCOUNT = "Account does not exist.\n";
	public static final String FILE_EXISTS = "File already exists in the account.\n";
	public static final String FILE_EXCEEDED = "File size exceeds account capacity.\n";
	public static final String FILE_SHARED = "File was shared.\n";
	public static final String NO_FILE = "File does not exist.\n";
	public static final String CANT_SHARE = "Account does not allow file sharing.\n";
	public static final String ALREADY_SHARED = "File already shared.\n";
	public static final String MINSPACE_YES = "Account with least free space: ";
	public static final String MINSPACE_NO = "No accounts.\n";
	public static final String ACCOUNT_FILES = "Account files:";
	public static final String ALL_ACCOUNTS = "All accounts:";
	public static final String EXIT = "Exiting...\n";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cloudSharing cs = new cloudSharing();
		Scanner in = new Scanner(System.in);
		String option = "";
		
		while(!option.equalsIgnoreCase(LEAVE)){
			option = in.next().toUpperCase();
			switch(option){
			case ADD:addAccount(in, cs);
				break;
			case UPLOAD:addFile(in, cs);
				break;
			case SHARE:shareFile(in, cs);
				break;
			case MINSPACE:accountWlfs(cs);
				break;
			case LISTFILES:listFiles(in, cs);
				break;
			case LISTALL:listAccounts(cs);
				break;
			case LEAVE: System.out.println(EXIT);
				break;
			}
		}

	}

	private static void addAccount(Scanner in, cloudSharing cs) {
		// TODO Auto-generated method stub
		String name = in.next().trim();
		String type = in.nextLine().trim();
		if(cs.hasUser(name)){
			System.out.println(ADD_INSUCCESS);
		}else{
			cs.addUser(name, type);
			System.out.println(ADD_SUCCESS);
		}
	}

	private static void addFile(Scanner in, cloudSharing cs) {
		// TODO Auto-generated method stub
		String name = in.next().trim();
		String file = in.next().trim();
		int size = in.nextInt();in.nextLine();
		if(!cs.hasUser(name)){
			System.out.println(NO_ACCOUNT);
		}else if(cs.hasFile(name, file)){
			System.out.println(FILE_EXISTS);
		}else if(cs.getFreeSpace(name)<size){
			System.out.println(FILE_EXCEEDED);
		}else{
			cs.addFile(name, file, size, name);
			System.out.println(UPLOAD_SUCCESS);
		}
	}

	private static void shareFile(Scanner in, cloudSharing cs) {
		// TODO Auto-generated method stub
		String from = in.next().trim();
		String to = in.next().trim();
		String file = in.nextLine().trim();
		if(!cs.hasUser(from) || !cs.hasUser(to)){
			System.out.println(NO_ACCOUNT);
		}else if(!cs.hasFile(from, file)){
			System.out.println(NO_FILE);
		}else if(!cs.canShareFile(from)){
			System.out.println(CANT_SHARE);
		}else if(cs.hasFileOwner(from, to, file, from)){
			System.out.println(ALREADY_SHARED);
		}else if(cs.canShareFile(from) && cs.getUserType(to).equalsIgnoreCase("basic") && cs.getFreeSpace(to)<(cs.getFileSize(from, file, from)/2)){
					System.out.println(FILE_EXCEEDED);
		}else{
			cs.shareFile(from, to, file, from);
			System.out.println(FILE_SHARED);
		}
	}

	private static void accountWlfs(cloudSharing cs) {
		// TODO Auto-generated method stub
		if(cs.numOfAccounts() == 0){
			System.out.println(MINSPACE_NO);
		}else{
			System.out.println(MINSPACE_YES + cs.getMinSpace() + "\n");
		}
	}

	private static void listFiles(Scanner in, cloudSharing cs) {
		// TODO Auto-generated method stub
		String name = in.nextLine().trim();
		if(!cs.hasUser(name)){
			System.out.println(NO_ACCOUNT);
		}else{
			Fileclass file;
			System.out.println(ACCOUNT_FILES);
			cs.InitFiles(name);
			while(cs.hasNextFile(name)){
				file = cs.nextFile(name);
				if(!cs.compareOwners(name, file.getName(),file.getOwner())){
					if(cs.getUserType(name).equalsIgnoreCase("basic")){
						int size = file.getSize() * 2;
						System.out.println(file.getName() + " (" + size + " MB)" + " (shared)");
					}else if(file.getSize() == 0){
						int size = cs.getOriginalSize(file.getName(),file.getOwner());
						System.out.println(file.getName() + " (" + size + " MB)" + " (shared)");
					}else{
						System.out.println(file.getName() + " (" + file.getSize() + " MB)" + " (shared)");
					}
				}else{
					System.out.println(file.getName() + " (" + file.getSize() + " MB)");
				}
			}
			System.out.println();
		}
	}

	private static void listAccounts(cloudSharing cs) {
		// TODO Auto-generated method stub
		cs.Init();
		System.out.println(ALL_ACCOUNTS);
		Userabstract Ua;
		while(cs.hasNext()){
			Ua = cs.Next();
			if(Ua.getType().equalsIgnoreCase("Premium")){
				System.out.println(Ua.getName() + " (Premium)");
			}else{
				System.out.println(Ua.getName() + " (Basic)");
			}
		}
		System.out.println();
	}

}

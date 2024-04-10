package p3_project;
import java.util.ArrayList;
import java.util.Scanner;
public class Accounts {
	public Scanner scan = new Scanner(System.in);	
	public boolean loop = false;
	private String admin_user = "admin";
	private String admin_pass = "admin";
	
	// Constructor
	private String username;
	private String password;
	
	public Accounts (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//Getters
	public String getAdmin_user () {
		return admin_user;
	}
	public String getAdmin_pass() {
		return admin_pass; 
	}
	
	public String getUsername () {
		return username;
	}
	public String getPassword() {
		return password; 
	}
	
	// Set ac
	public void acc_autoAdd() {
		Accounts account1 = new Accounts("user1", "user1");
		Accounts account2 = new Accounts("user2", "user2");
		Accounts account3 = new Accounts("user3", "user3");
		Accounts account4 = new Accounts("user4", "user4");
		accounts_Arr.add(account1);
		accounts_Arr.add(account2);
		accounts_Arr.add(account3);
		accounts_Arr.add(account4);
		
	}
	private static ArrayList <Accounts> accounts_Arr = new ArrayList<Accounts>();
	
	public ArrayList<Accounts> getAccounts_arr () {
		return accounts_Arr;
	}
	
	// add/remove account method for the admin's use\
//	public Main main = new Main();
	
	public void addAccount (String username, String password) {
		Accounts newAcc = new Accounts(username, password);
		accounts_Arr.add(newAcc);
		
		System.out.println("Account Added Successfully!");
		
		// after adding account return to addmin menu
		
		Main.admin_menu();
		
		//for each loop for displaying current account purposes (must delete)
		
//		for (Accounts accs : accounts_Arr) {
//			System.out.println(accs.getUsername()+ accs.getPassword());
//		}
	}
	public int account_size;
	public void removeAccount () {
		
		account_size = accounts_Arr.size();
		if (account_size == 0) {
			System.out.println("No accounts found\n\n");
			Main.admin_menu();	
		}
		else {
		System.out.println("\n\n\tRemove account\n"
				+ "Account # \tUsername\tPassword");
		
		for (int i = 0; i < account_size; i++) {
			Accounts accountInfo = accounts_Arr.get(i);
			System.out.printf("%n [%d]      \t%s     \t%s", i+1, accountInfo.getUsername(), accountInfo.getPassword());
		}
		int acc_no = 0;
		String p = "";
		do {
			try {
			System.out.print("\n>>>");
			p = scan.next();
			acc_no = Integer.parseInt(p);
			if (acc_no == 0 | acc_no > account_size) {
				System.out.println("Invalid input, please refer to\nthe account number above.");
				loop = true;
			}
			else {
				loop = false;
			}
			} catch (Exception e) {
				loop = true;
				System.out.println("Invalid input, please try again.");
			}
		} while (loop);
		accounts_Arr.remove(acc_no - 1);
		System.out.println("Account Removed Successfully!\n\n");
		
		Main.admin_menu();	
		}
	}
	
}
	


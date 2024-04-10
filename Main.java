package p3_project;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;


public class Main {
	
	public static Accounts account = new Accounts(null, null);
	public static final Scanner scan = new Scanner(System.in);
	public static boolean loop;
	public static int account_size = account.getAccounts_arr().size();
	
	public static void main(String[] args) {
		System.out.println("");
		account.acc_autoAdd();
		login();
	}
	
	static void login () {
		final Accounts admin_acc = new Accounts(null, null);
		do {
		System.out.println("\tLogin");
		System.out.print("Enter username: ");
		String login_user = scan.next();
		System.out.print("Enter password: ");
		String login_pass = scan.next();
		int account_size = account.getAccounts_arr().size();
		
		if (login_user.equals(admin_acc.getAdmin_user())& login_pass.equals(admin_acc.getAdmin_pass())) {
			System.out.println("\n\n\t Welcome Admin!");
			loop = false;
			admin_menu();
		}
		else if (account_size == 0) {
			System.out.println("Wrong Username or Password, please try again\n\n");
			loop = true;
		}
		else {
			
			for(int i = 0; i < account_size; i++) {
				Accounts accountInfo = account.getAccounts_arr().get(i);
				if (login_user.equals(accountInfo.getUsername()) & login_pass.equals(accountInfo.getPassword())) {
					System.out.printf("\n\n\tWelcome " + accountInfo.getUsername() + "!");
					break;
				}
				else if (i == account_size-1) {
					System.out.println("Wrong Username or Password, please try again");
					loop = true;
					break;
				}
			}
		} 
		
		}while (loop);
	}
	public static Items item = new Items ("", 0, null);
	static void admin_menu () {
		System.out.println("\n\n\tInventory System");
		System.out.print("\n1. Add/Remove Account"
				+ "\n2. Add/Remove Item "
				+ "\n3. Update"
				+ "\n4. Archive"
				+ "\n5. Display"
				+ "\n\n>>>");
		String choice = scan.next();
		
		switch (choice) {
		case "1":
			do {
				loop = false;
				System.out.print("\n\n[A] Add account \t[R] Remove account"
					+ "\n>>>");
				choice = scan.next();
			if (choice.equalsIgnoreCase("a")) {
				System.out.print("\tAdd new Account"
						+ "\nEnter username: ");
				String username = scan.next();
				System.out.print("\nEnter password: ");
				String password = scan.next();
				account.addAccount(username, password);
			}
			else if (choice.equalsIgnoreCase("R")) {
				account.removeAccount();
			}
			else {
				System.out.println("Invalid input, please try again");
				loop = true;
			}
		}while (loop);
			break;
			
		case "2":
			do {
				
				loop = false;
				System.out.print("\n\n[A] Add new item \t[R] Remove item"
						+ "\n>>>");
				choice = scan.next();
				if (choice.equalsIgnoreCase("A")) {
					item.addItem();
				}
				else if (choice.equalsIgnoreCase("R")) {
					item.removeItem();
				}
				else {
					System.out.println("Invalid input, please try again");
					loop= true;
				}
				System.out.print("\n");
				
			} while (loop);
			break;
		case "3":
			item.updateItem();
			break;
		}
	}
	
	static void user_menu () {
		
	}
}

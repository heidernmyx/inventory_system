package p3_project;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Items {
	public Scanner scan = new Scanner(System.in);
	
	public boolean loop;
	
	private String item_name;
	private int quantity;
	private LocalDateTime date_time;
	
	public Items (String item_name, int quantity, LocalDateTime date_time) {
		this.item_name = item_name;
		this.quantity = quantity;
		this.date_time = date_time;
	}
	
	
	
	public ArrayList <Items> getItems_arr () {
		return items_Arr;
	}
	
	public String getItem_name () {
		return item_name;
	}
	
	public int getQuantity () {
		return quantity;
	}
	
	public String getDT () {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
		date_time = LocalDateTime.now();
		String str_date_time = date_time.format(formatter);
		return str_date_time;
	}
	
	private static ArrayList <Items> items_Arr = new ArrayList <Items>();
	
	public String p = "";
//	private Items item = new Items(null, 0, null);
	
	public void addItem () {
		loop = false;
		System.out.print("\tAdd item\n"
				+ "Enter item name: ");
		item_name = scan.next();
		
		quantity = 0;
		do {
			try {
				System.out.print("\nEnter quantity: ");
				p = scan.next();
				quantity = Integer.parseInt(p);
				if (quantity <=0) {
					System.out.println("\n\nInvalid input, please enter number 1 or above");
					loop = true;
				}
				else {
					loop = false;
				}
			} catch (Exception e) {
				System.out.print("\n\nInvalid input, please try again");
				loop = true;
			}
		} while (loop);
		Items newItem = new Items (item_name, quantity, date_time);
		items_Arr.add(newItem);
		System.out.println("Item Added Successfully!");
		
		
		do {
			System.out.print("\nAdd item again?\n"
					+ "[Y] Yes\t [N] no\n>>>");
			String choice = scan.next();
			if (choice.equalsIgnoreCase("Y")) {
				addItem();
			}
			else if (choice.equalsIgnoreCase("N")) {
				loop = false;
				Main.admin_menu();
			}
			else {
				System.out.println("Invalid input, please try again.");
				loop = true;
			}
		} while (loop);
		
//		 for printing item array values purposes
		
//		for (int i = 0 ; i < items_size; i++) {
//			Items item_info = items_Arr.get(i);
//			System.out.printf("\n[%d] %s %d %s", i+1,  item_info.getItem_name(), item_info.getQuantity(), item_info.getDT());
//		}
		Main.admin_menu();
	}
	int item_no = 0;
	int items_size;
	public void removeItem () {
		do {
			items_size = items_Arr.size();
			if (items_size == 0) {
				System.out.println("\nNo Item Found");
				Main.admin_menu();
			}
		System.out.println("\n\n\tRemove item"
				+ "\nItem # \tItem Name\tItem Quantity\tDate/Time added");
		for (int i = 0 ; i < items_size; i++) {
			Items item_info = items_Arr.get(i);
			System.out.printf("\n [%d] \t %s \t   %d \t\t%s", i+1, item_info.getItem_name(), item_info.getQuantity(), item_info.getDT());
		}
		
		do {
			try {
				System.out.print("\n>>>");
				p = scan.next();
				item_no = Integer.parseInt(p);
				if (item_no <=0 | item_no > items_size) {
					System.out.println("\n\nInvalid input, please refer to\nthe item number above.");
					loop = true;
				}
				else {
					loop = false;
				}
			} catch (Exception e) {
				System.out.print("\nInvalid input, please try again");
				loop = true;
			}
		} while (loop);
		items_Arr.remove(item_no - 1);
		System.out.println("Item Removed Successfully");
		
		do {
			System.out.print("\nRemove item again?\n"
					+ "[Y] Yes\t [N] no\n>>>");
			String choice = scan.next();
			if (choice.equalsIgnoreCase("Y")) {
				removeItem();
			}
			else if (choice.equalsIgnoreCase("N")) {
				loop = false;
				Main.admin_menu();
			}
			else {
				System.out.println("Invalid input, please try again.");
				loop = true;
			}
		} while (loop);
		
		} while (loop);
	}
	
	public void updateInfoname (String newName) {
		this.item_name = newName;
	}
	public void updateInfoquantity (int newQuantity) {
		this.quantity = newQuantity;
	}
	
	public void updateItem () {
		items_size = items_Arr.size();
		System.out.println("\n\n\tSelect Item to Update"
				+ "\nItem # \tItem Name\tItem Quantity\tDate/Time added");
		for (int i = 0 ; i < items_size; i++) {
			Items item_info = items_Arr.get(i);
			System.out.printf("\n [%d] \t %s \t   %d \t\t%s", i+1, item_info.getItem_name(), item_info.getQuantity(), item_info.getDT());
		}
		do {
			try {
				System.out.print("\n\n>>>");
				p = scan.next();
				item_no = Integer.parseInt(p);
				if (item_no ==0 | item_no > items_size) {
					System.out.println("\n\nInvalid input, please refer to\nthe item number above.");
					loop = true;
				}
				else {
					loop = false;
				}
			} catch (Exception E) {
				System.out.println("Invalid input, please try again.");
				loop = true;
			}
		} while (loop);
		
		do {
		System.out.println("[R] Rename \t[E] Edit quantity\n>>>");
		String choice = scan.next();
		// Rename
		if (choice.equalsIgnoreCase("R")) {
			System.out.print("\nEnter new name: ");
			String newName = scan.next();
			items_Arr.get(item_no-1).updateInfoname(newName);
		}
		// Edit quantity
		else if (choice.equalsIgnoreCase("E")) {
			
			System.out.print("\n[A] Add/Increase quantity \t[D] Decrease quantity \t[S] Set quantity\n>>>");
			choice = scan.next().toUpperCase();
			do {
				switch (choice) {
				
				// Add quantity
				case "A":
					System.out.print("Enter number to increase: ");
					
					int newQuantity = numberEdit(0);
					items_Arr.get(item_no-1).updateInfoquantity(getQuantity() + newQuantity);
					
					System.out.println("Item Updated Successfully");
					break;
					
				
				case "D":
				
				case "S":
				}
				
			} while (loop);
			
//			do {
//				try {
//			System.out.print("Enter new: ");
//			String newName = scan.next();
//			items_Arr.get(item_no-1).updateInfo(newName, quantity);
//				} catch (Exception e) {
//					
//				}
//			} while (loop);
		}
		else {
			
		}
		} while (loop);
	
	}
	
	public int numberEdit (int quantity) {
		do {
				try {
				p = scan.next();
				quantity = Integer.parseInt(p);
				loop = false;
				if (quantity <= 0) {
					System.out.print("Invalid input, please only\nenter number 1 or above\n"
							+ "\nEnter number");
				}
			} catch (Exception e) {
				System.out.println("Invalid input, please try again");
				
			}
		} while (loop);
		return quantity;
	}	
}
	


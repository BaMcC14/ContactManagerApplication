package pgiptech;

import java.util.Scanner;


public class OptionMenu {

	
	public static void optionMenu() {
		
			Scanner scanner = new Scanner(System.in);
			try {
			System.out.println("***Please choose from the following options:***");
			System.out.println("Option 1 : Add a new contact");
			System.out.println("Option 2 : Edit an existing contact");
			System.out.println("Option 3 : View all contacts");
			System.out.println("Option 4 : Delete contacts");
			System.out.println("Please enter a number between 1 and 4");
			
			while(!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("***Please choose from the following options:***");
				System.out.println("Option 1 : Add a new contact");
				System.out.println("Option 2 : Edit an existing contact");
				System.out.println("Option 3 : View all contacts");
				System.out.println("Option 4 : Delete contacts");
				System.out.println("Please enter a number between 1 and 4");
			}
			
			int selection = scanner.nextInt();
			
			if(selection >=1 && selection <= 4) {
			
			if(selection == 1) {
				System.out.println("Option 1");
				//call AddContact method
				AddContact.addContact();
			}
			else if(selection == 2) {
				System.out.println("Option 2");
				SearchContacts.searchContacts();
			}
			else if(selection == 3) {
				System.out.println("Option 3");
				//call ViewContact method
				ViewAllContacts.viewAll();
			}
			else if(selection == 4) {
				System.out.println("Option 4");
				//call DeleteContact method
			}
			
			}
			
			else {
				optionMenu();
			}
			}//end of try block
			
			
			catch (Exception e) {
				System.out.println("Please Select a number between 1 and 4.");
				
			}//end of catch block
		
	}
}

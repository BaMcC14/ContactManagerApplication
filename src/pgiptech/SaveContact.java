package pgiptech;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class SaveContact {

	static JSONObject contactList = new JSONObject();	
	
	@SuppressWarnings("unchecked")
	public static void createContact() {
			Contact myContact = new Contact();
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Enter First Name: ");
			myContact.setFirstName(scanner.next());
				System.out.print("Enter Last Name: ");
			myContact.setLastName(scanner.next());
				System.out.print("Enter Phone Number: ");
			myContact.setPhoneNumber(scanner.next());
				System.out.print("Enter Email: ");
			myContact.setEmail(scanner.next());
				
			contactList.put("First Name", myContact.getFirstName());
			contactList.put("Last Name", myContact.getLastName());
			contactList.put("Phone Number", myContact.getPhoneNumber());
			contactList.put("Email", myContact.getEmail());	
			scanner.close();

			
			if(counter >= 1) {
				addNewContact(contactList);
			}else {
				addContact(contactList);
			}
			
			}
	static int counter = 1;
	static JSONObject jsonObject = new JSONObject();
	static JSONObject myList = new JSONObject();
	
	@SuppressWarnings("unchecked")
	public static void addNewContact(JSONObject contactList) {
		Scanner scanner = new Scanner(System.in);
		jsonObject.put("contact"+counter, contactList);
		myList.put("MyContacts", jsonObject);
		counter++;
		
		System.out.print("Save Contact? Y/N: ");
		String response = scanner.next();
		char answer = response.charAt(0);
		if(answer == 'y' || answer == 'Y' ) {
			try {
				File file = new File("src/info.json");
				if(!file.exists()) {
					file.createNewFile();
				}
				FileWriter fileWriter = new FileWriter("src/info.json", true);
				fileWriter.write(jsonObject.toJSONString()+ "\n");
				fileWriter.flush();
				fileWriter.close();
				System.out.println("\n**Contact Saved**\n\n");
				scanner.close();
				OptionMenu.optionMenu();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("\nSave was unsuccessful");
				System.out.println("Contact Not Saved");
				OptionMenu.optionMenu();
			}
			}else {
				System.out.println("Contact Not Saved");
			}
			}
			
		
	
	
	@SuppressWarnings("unchecked")
	public static void addContact(JSONObject contactList) {
		jsonObject.put("contact"+counter, contactList);
		counter++;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Save Contact? Y/N: ");
		String response = scanner.next();
		char answer = response.charAt(0);
		if(answer == 'y' || answer == 'Y' ) {
			try {
				File file = new File("src/info.json");
				if(!file.exists()) {
					file.createNewFile();
				}
				FileWriter fileWriter = new FileWriter("src/info.json", true);
				fileWriter.write(jsonObject.toJSONString()+ "\n");
				fileWriter.flush();
				fileWriter.close();
				System.out.println("\n**Contact Saved**\n\n");
				scanner.close();
				OptionMenu.optionMenu();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("\nSave was unsuccessful");
				System.out.println("Contact Not Saved");
				OptionMenu.optionMenu();
			}
			}else {
				System.out.println("Contact Not Saved");
			}
			}
			
	
	
	
	
	
	
	
	
	
	
}

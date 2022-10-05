package pgiptech;


import java.io.File;
import java.io.FileWriter;

import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class AddContact {


	public static void addContact() {

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
		
	JSONObject contactList = new JSONObject();	
	
	contactList.put("First Name", myContact.getFirstName());
	contactList.put("Last Name", myContact.getLastName());
	contactList.put("Phone Number", myContact.getPhoneNumber());
	contactList.put("Email", myContact.getEmail());	
		
	JSONArray myList = new JSONArray();	
	myList.add(contactList);
	
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("contact", myList);
	

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

	
		



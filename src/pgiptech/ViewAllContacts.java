package pgiptech;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ViewAllContacts{
	
	public static void viewAll() throws IOException, ParseException {
		
		System.out.println("Your Contact List:");
		
		JSONParser jsonparser = new JSONParser();
			
				
		try {
			System.out.println("Start");
			
			FileReader reader = new FileReader(".\\src\\info.json");
			System.out.println("File Found");
			
					
			Object obj = jsonparser.parse(reader);
			System.out.println("Parse obj");
			
						
			JSONObject jsonObject = (JSONObject) obj;
			System.out.println("Create JSONObject");
			
			
						
			//JSONArray contactArray = (JSONArray)jsonObject.get("1");
			
//			for(int i = 0; i < contactArray.size(); i++) {
//				JSONObject myContact = (JSONObject) contactArray.get(i);
//				//System.out.println(i);				
//				String email = (String) myContact.get("Email");
//				String fName = (String) myContact.get("First Name");
//				String lName = (String) myContact.get("Last Name");
//				String pNumber = (String) myContact.get("Phone Number");
//				System.out.println(fName);
//				System.out.println(lName);
//				System.out.println(pNumber);
//				System.out.println(email);
//				}
//			
//			jsonObject.get("contact");
//			

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//			File file = new File("src/pgiptech/info.json");
//			Scanner scanner = new Scanner(file);
//			String info = "";
//			while(scanner.hasNext()) {
//			info = scanner.nextLine();
//			System.out.println(info);
//			}
//			scanner.close();
	}
}

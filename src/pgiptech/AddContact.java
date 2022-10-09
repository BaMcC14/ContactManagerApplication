package pgiptech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class AddContact {
	
	public static void addContact() throws SQLException {

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
	
		
	String connectionString = 
			"jdbc:sqlserver://DESKTOP-7JNHD5O:1433;Database=ContactManagerApp;trustServerCertificate=true;IntegratedSecurity=true";
	
	Connection conn = null;
	Statement stmt = null;
	
	System.out.print("Save Contact? Y/N: ");
	String response = scanner.next();
	char answer = response.charAt(0);
	
	if(answer == 'y' || answer == 'Y' ) {
	try {
	conn = DriverManager.getConnection(connectionString);
	stmt = conn.createStatement();	
		
	String sql = "INSERT INTO ContactTable " + 
	"VALUES (" + "'" + myContact.getFirstName() + "','" + myContact.getLastName() + "','" + myContact.getPhoneNumber() + "','" + myContact.getEmail() +"'"+ ")";
	stmt.executeUpdate(sql);
	
	System.out.println("Record Added\n\n");
	OptionMenu.optionMenu();
	
	}catch(SQLException se) {
		se.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();		
	}finally {
		try {
			if(stmt != null) 
				conn.close();
			}catch(SQLException es) {
				
			}		
		try {
			if(conn != null)
				conn.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		}
	}

} 
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		



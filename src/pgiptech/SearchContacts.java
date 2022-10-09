package pgiptech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchContacts {

	
	public static void searchContacts() {
	Scanner scanner = new Scanner(System.in);
		
	System.out.println("How would you like to search?");
	System.out.println("1.) First Name");
	System.out.println("2.) Last Name");
	System.out.println("3.) Phone Number");
	System.out.println("4.) Email");
	
	int selection = scanner.nextInt();
	
	if(selection >=1 && selection <= 4) {
		String connectionString = 
				"jdbc:sqlserver://DESKTOP-7JNHD5O:1433;Database=ContactManagerApp;trustServerCertificate=true;IntegratedSecurity=true";
		
		Connection conn = null;
		Statement stmt = null;
		
		switch(selection) {
		case 1:
			searchByFirstName();
			break;
		case 2:
			searchByLastName();
			break;
		case 3:
			searchByPhoneNumber();
			break;
		case 4:
			searchByEmail();
			break;
		}
		
		}else {
			searchContacts();
		}

	}
	
	
	
	public static void searchByFirstName() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter First Name: ");
		String firstName = scanner.next();
		
		String connectionString = 
				"jdbc:sqlserver://DESKTOP-7JNHD5O:1433;Database=ContactManagerApp;trustServerCertificate=true;IntegratedSecurity=true";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(connectionString);
			stmt = conn.createStatement();	
				
			String sql = "SELECT FirstName, LastName, PhoneNumber, Email FROM ContactTable WHERE FirstName =" +"'"+ firstName +"'"+";";
			stmt.execute(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String fName = rs.getString("FirstName");
				String lName = rs.getString("LastName");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				System.out.println("\n" + fName +" "+ lName +" "+ phoneNumber +" "+ email);
			}
			
			if(rs.getFetchSize() > 4) {
				System.out.println("Your result is greater than 1");
				System.out.println("Please search by another criteria.");
				System.out.println(rs.getFetchSize());
				searchContacts();
				
			}else {
				System.out.println("Less than one.");
			}
			
			
		
		System.out.println("\n\n");
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
		
	public static void searchByLastName() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Last Name: ");
		String lastName = scanner.next();

		String connectionString = 
				"jdbc:sqlserver://DESKTOP-7JNHD5O:1433;Database=ContactManagerApp;trustServerCertificate=true;IntegratedSecurity=true";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(connectionString);
			stmt = conn.createStatement();	
				
			String sql = "SELECT FirstName, LastName, PhoneNumber, Email FROM ContactTable WHERE LastName =" +"'"+ lastName +"'"+";";
			stmt.execute(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String fName = rs.getString("FirstName");
				String lName = rs.getString("LastName");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				System.out.println("\n" + fName +" "+ lName +" "+ phoneNumber +" "+ email);
			}
			
			if(rs.getFetchSize() > 1) {
				System.out.println("Your result is greater than 1");
				System.out.println("Please search by another criteria.");
				System.out.println(rs.getFetchSize());
				searchContacts();
				
			}else {
				System.out.println("Less than one.");
			}
			
			
		
		System.out.println("\n\n");
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

	public static void searchByPhoneNumber() {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Enter Phone Number: ");
	String pNumber = scanner.next();
	
	String connectionString = 
			"jdbc:sqlserver://DESKTOP-7JNHD5O:1433;Database=ContactManagerApp;trustServerCertificate=true;IntegratedSecurity=true";
	
	Connection conn = null;
	Statement stmt = null;
	
	try {
		conn = DriverManager.getConnection(connectionString);
		stmt = conn.createStatement();	
			
		String sql = "SELECT FirstName, LastName, PhoneNumber, Email FROM ContactTable WHERE PhoneNumber =" +"'"+ pNumber +"'"+";";
		stmt.execute(sql);
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			String fName = rs.getString("FirstName");
			String lName = rs.getString("LastName");
			String phoneNumber = rs.getString("PhoneNumber");
			String email = rs.getString("Email");
			System.out.println("\n" + fName +" "+ lName +" "+ phoneNumber +" "+ email);
		}
		
		if(rs.getFetchSize() > 1) {
			System.out.println("Your result is greater than 1");
			System.out.println("Please search by another criteria.");
			System.out.println(rs.getFetchSize());
			searchContacts();
			
		}else {
			System.out.println("Less than one.");
		}
		
		
	
	System.out.println("\n\n");
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
	
	public static void searchByEmail() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Email: ");
		String Email = scanner.next();
		
		String connectionString = 
				"jdbc:sqlserver://DESKTOP-7JNHD5O:1433;Database=ContactManagerApp;trustServerCertificate=true;IntegratedSecurity=true";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(connectionString);
			stmt = conn.createStatement();	
				
			String sql = "SELECT FirstName, LastName, PhoneNumber, Email FROM ContactTable WHERE Email =" +"'"+ Email +"'"+";";
			stmt.execute(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String fName = rs.getString("FirstName");
				String lName = rs.getString("LastName");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				System.out.println(fName +" "+ lName +" "+ phoneNumber +" "+ email);
			}
			
			
			
			if(rs.getFetchSize() > 1) {
				System.out.println("Your result is greater than 1");
				System.out.println("Please search by another criteria.");
			
				searchContacts();
				
			}else {
				System.out.println("Less than one.");
			}
			
			
		
		System.out.println("\n\n");
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

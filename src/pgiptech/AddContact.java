package pgiptech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.text.ParseException;
import java.util.regex.Pattern;

public class AddContact {
	static Contact myContact = new Contact();

	public static void addContact() throws SQLException {

		Scanner scanner = new Scanner(System.in);

		addFirstName();

		addLastName();

		addPhoneNumber();

		addEmail();

		String connectionString = "jdbc:sqlserver://DESKTOP-7JNHD5O:1433;Database=ContactManagerApp;trustServerCertificate=true;IntegratedSecurity=true";

		Connection conn = null;
		Statement stmt = null;

		System.out.print("Save Contact? Y/N: ");
		String response = scanner.next();
		char answer = response.charAt(0);

		if (answer == 'y' || answer == 'Y') {

			try {
				conn = DriverManager.getConnection(connectionString);
				stmt = conn.createStatement();
				/*
				 * SQL Statement INSERT INTO Contact Table VALUES ('FirstName', 'LastName',
				 * 'PhoneNumber', 'Email');
				 */
				String sql = "INSERT INTO ContactTable " + "VALUES (" + "'" + myContact.getFirstName() + "','"
						+ myContact.getLastName() + "','" + myContact.getPhoneNumber() + "','" + myContact.getEmail()
						+ "'" + ");";

				stmt.executeUpdate(sql);

				System.out.println("Contact Added\n");

			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Contact Not Added.");

		}

		OptionMenu.optionMenu();

	}// End of Method addContact

	static Scanner scanner = new Scanner(System.in);

	public static void addFirstName() {
		System.out.print("Enter First Name: ");
		myContact.setFirstName(scanner.next());
		boolean isValid = true;

		for (int i = 0; i < myContact.getFirstName().length(); i++) {
			char ch = myContact.getFirstName().charAt(i);
			if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
				continue;
			}
			isValid = false;
		}

		if (isValid == false) {
			System.out.println("Letters Only!");
			addFirstName();
		}
	}

	public static void addLastName() {
		System.out.print("Enter Last Name: ");
		myContact.setLastName(scanner.next());
		boolean isValid = true;

		for (int i = 0; i < myContact.getLastName().length(); i++) {
			char ch = myContact.getLastName().charAt(i);
			if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
				continue;
			}
			isValid = false;
		}

		if (isValid == false) {
			System.out.println("Letters Only!");
			addLastName();
		}
	}

	public static void addPhoneNumber() {
		System.out.print("Enter Phone Number: ");
		myContact.setPhoneNumber(scanner.next());
		boolean isValid = true;

		for (int i = 0; i < myContact.getPhoneNumber().length(); i++) {
			char ch = myContact.getPhoneNumber().charAt(i);
			if (ch >= '0' && ch <= '9') {
				continue;
			}
			isValid = false;
		}
		if (isValid == false) {
			System.out.println("Numbers Only!");
			addPhoneNumber();
		}
	}

	public static void addEmail() {
		System.out.println("Enter Email Address:");
		myContact.setEmail(scanner.next());
		boolean isValid = true;

		if (myContact.getEmail().contains("@") && myContact.getEmail().contains(".com")) {
			isValid = true;
		}

		else {
			isValid = false;
		}
		if (isValid == false) {
			System.out.println("Invalid Email Address!");
			addEmail();
		}
	}

}// End of Class AddContact

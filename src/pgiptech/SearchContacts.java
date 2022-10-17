package pgiptech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchContacts {

	public static void searchContacts() {

		searchByPhoneNumber();

	}

	public static void searchByPhoneNumber() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Phone Number to edit: ");
		String pNumber = scanner.next();

		Connection conn = null;
		Statement stmt = null;

		String connectionString = "jdbc:sqlserver://DESKTOP-7JNHD5O:1433;Database=ContactManagerApp;trustServerCertificate=true;IntegratedSecurity=true";

		try {
			conn = DriverManager.getConnection(connectionString);
			stmt = conn.createStatement();

			String sql = "SELECT * " + "FROM ContactTable " + "WHERE PhoneNumber =" + "'" + pNumber + "';";

			stmt.execute(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String fName = rs.getString("FirstName");
				String lName = rs.getString("LastName");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				System.out.println(fName + " " + lName + " " + phoneNumber + " " + email);
			}
			

			System.out.println("What would you like to edit in this contact?");
			System.out.println("1.) First Name");
			System.out.println("2.) Last Name");
			System.out.println("3.) Phone Number");
			System.out.println("4.) Email");

			int editSelection = scanner.nextInt();

			if (editSelection >= 1 && editSelection <= 4) {

				switch (editSelection) {

				case 1:

					System.out.println("Enter Updated First Name: ");
					String firstName = scanner.next();

					try {
						conn = DriverManager.getConnection(connectionString);
						stmt = conn.createStatement();

						String sql1 = "UPDATE ContactTable" + " SET FirstName = " + "'" + firstName + "'"
								+ " WHERE PhoneNumber = " + "'" + pNumber + "';";

						stmt.execute(sql1);

						System.out.println("Contact Updated!");
						OptionMenu.optionMenu();
					} finally {
						try {
							if (stmt != null)
								conn.close();
						} catch (SQLException es) {

						}
						try {
							if (conn != null)
								conn.close();
						} catch (SQLException se) {
							se.printStackTrace();
						}
					}

				case 2:

					System.out.println("Enter Updated Last Name: ");
					String LastName = scanner.next();

					try {
						conn = DriverManager.getConnection(connectionString);
						stmt = conn.createStatement();

						String sql1 = "UPDATE ContactTable" + " SET LastName = " + "'" + LastName + "'"
								+ " WHERE PhoneNumber = " + "'" + pNumber + "';";

						stmt.execute(sql1);

						System.out.println("Contact Updated!\n");
						OptionMenu.optionMenu();
					} finally {
						try {
							if (stmt != null)
								conn.close();
						} catch (SQLException es) {

						}
						try {
							if (conn != null)
								conn.close();
						} catch (SQLException se) {
							se.printStackTrace();
						}
					}

				case 3:

					System.out.println("Enter Updated Phone Number: ");
					String phoneNumber = scanner.next();

					try {
						conn = DriverManager.getConnection(connectionString);
						stmt = conn.createStatement();

						String sql1 = "UPDATE ContactTable" + " SET PhoneNumber = " + "'" + phoneNumber + "'"
								+ " WHERE PhoneNumber = " + "'" + pNumber + "';";

						stmt.execute(sql1);

						System.out.println("Contact Updated!\n");
						OptionMenu.optionMenu();
					} finally {
						try {
							if (stmt != null)
								conn.close();
						} catch (SQLException es) {

						}
						try {
							if (conn != null)
								conn.close();
						} catch (SQLException se) {
							se.printStackTrace();
						}
					}

				case 4:

					System.out.println("Enter Updated Email: ");
					String Email = scanner.next();

					try {
						conn = DriverManager.getConnection(connectionString);
						stmt = conn.createStatement();

						String sql1 = "UPDATE ContactTable" + " SET Email = " + "'" + Email + "'"
								+ " WHERE PhoneNumber = " + "'" + pNumber + "';";

						stmt.execute(sql1);

						System.out.println("Contact Updated!\n");
						OptionMenu.optionMenu();
					} finally {
						try {
							if (stmt != null)
								conn.close();
						} catch (SQLException es) {

						}
						try {
							if (conn != null)
								conn.close();
						} catch (SQLException se) {
							se.printStackTrace();
						}
					}

				}
				
			} 
			OptionMenu.optionMenu();
			System.out.println("\n\n");
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// End of method searchByPhoneNumber
}// End of class SearchContacts

package pgiptech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteContact {

	public static void deleteContact() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Phone Number to Delete: ");
		String pNumber = scanner.next();

		Connection conn = null;
		Statement stmt = null;
		Statement stmt2 = null;

		String connectionString = "jdbc:sqlserver://DESKTOP-7JNHD5O:1433;Database=ContactManagerApp;trustServerCertificate=true;IntegratedSecurity=true";

		try {
			conn = DriverManager.getConnection(connectionString);
			stmt = conn.createStatement();

			String sql = "SELECT * " + "FROM ContactTable " + "WHERE PhoneNumber =" + "'" + pNumber + "';";

			stmt.execute(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String fName = rs.getString("FirstName");
				String lName = rs.getString("LastName");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				System.out.println(fName + " " + lName + " " + phoneNumber + " " + email);
			}
			System.out.println("Delete this contact?  Y/N: ");

			String response = scanner.next();
			char answer = response.charAt(0);
			

			if (answer == 'y' || answer == 'Y') {
				stmt2 = conn.createStatement();
				String sql2 = "DELETE FROM ContactTable WHERE PhoneNUmber =" + "'" + pNumber + "';";
				stmt2.execute(sql2);
				System.out.println("Contact Deleted.\n");
				
			} else {
				System.out.println("Contact Not Deleted.\n");
				
				// OptionMenu.optionMenu();
			}
			
			OptionMenu.optionMenu();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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

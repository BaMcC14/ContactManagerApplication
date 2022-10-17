package pgiptech;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewAllContacts {

	public static void viewAll() throws IOException {

		System.out.println("Your Contact List:\n");

		String connectionString = "jdbc:sqlserver://DESKTOP-7JNHD5O:1433;Database=ContactManagerApp;trustServerCertificate=true;IntegratedSecurity=true";

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(connectionString);
			stmt = conn.createStatement();

			String sql = "SELECT FirstName, LastName, PhoneNumber, Email FROM ContactTable ORDER BY FirstName;";
			stmt.execute(sql);

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String fName = rs.getString("FirstName");
				String lName = rs.getString("LastName");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				System.out.println(fName + " " + lName + " " + phoneNumber + " " + email);
			}
			System.out.println("\n\n");
			
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

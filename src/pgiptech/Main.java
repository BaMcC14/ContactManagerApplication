package pgiptech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		String connectionString = "jdbc:sqlserver://DESKTOP-7JNHD5O:1433;Database=ContactManagerApp;trustServerCertificate=true;IntegratedSecurity=true";

		try {
			try (Connection connection = DriverManager.getConnection(connectionString)) {
				System.out.println("Connection established.");

			}
		} catch (SQLException e) {
			System.out.println("Error connecting to the database");
			e.printStackTrace();
		}

		OptionMenu.optionMenu();
	}

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public abstract class Connector {
	
	public static Connection CreateConnection(String username, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver not Found!!!");
			JOptionPane.showMessageDialog(null, "JDBC Driver not Found", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", username, password);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}
	
		return con;
	}
	
	public static void TerminateConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Cannot terminate the connection safely.");
			e.printStackTrace();
		}
	}
	
	
}

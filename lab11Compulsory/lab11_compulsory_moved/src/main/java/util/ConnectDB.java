package util;
import java.sql.*;

public class ConnectDB {

	static Connection myConn = null;
	 public ResultSet result;

	public static Connection getConnection() {
		if (myConn == null) {

			Statement myStmt = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/musicalbums3", "root",
						"stefan123");

				if (myConn != null)

				{
					System.out.println("connected succesfully");
				}
			} catch (Exception e) {
				System.out.println("not connected to the server");

			}
		}
		return myConn;
	}
}
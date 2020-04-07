package lab8_comp;

import com.mysql.jdbc.Statement;
import com.sun.jdi.connect.spi.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArtistController {

	public void create(String name, String country) {
		Connection myConn = (Connection) ConnectDB.getConnection();
		try {
			Statement myStmt = myConn.createStatement();
			String s = "INSERT INTO artists (name,country) VALUES (" + "'" + name + "'" + "," + "'" + country + "'"+ ")";
			System.out.println(s);
			myStmt.executeUpdate(s);

		} catch (Exception ex) {
			Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void findByName(String name) {
		Connection myConn = (Connection) ConnectDB.getConnection();
		try {
			Statement myStmt = myConn.createStatement();
			String string = "SELECT * from artists";
			ResultSet result = myStmt.executeQuery(string);
			while (result.next()) {
				int code = result.getInt("id");
				String country = result.getString("country");
				System.out.println(code + ", " + country);
			}

		} catch (SQLException ex) {
			Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

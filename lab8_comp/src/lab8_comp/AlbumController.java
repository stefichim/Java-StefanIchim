package lab8_comp;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.sun.jdi.connect.spi.Connection;

public class AlbumController {
	public void create(String name, int artistId, int releaseYear) {
		Connection myConn = (Connection) ConnectDB.getConnection();
		try {
			Statement myStmt = myConn.createStatement();
			String s = "INSERT INTO albums (name,artist_id,release_year) VALUES (" + "'" + name + "'" + "," + "'"+ artistId + "'" + "," + "'" + releaseYear + "'" + ")";
			System.out.println(s);
			myStmt.executeUpdate(s);

		} catch (SQLException ex) {
			Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void findByArtist(int artistId) {
		Connection conn = (Connection) ConnectDB.getConnection();
		try {
			Statement myStmt = conn.createStatement();
			String string = "SELECT name,release_year FROM albums WHERE artist_id=" + "'" + artistId + "'";
			ResultSet result = myStmt.executeQuery(string);
			while (result.next()) {
				String name = result.getString("name");
				int releaseId = result.getInt("release_year");
				System.out.println(name + ", " + releaseId);
			}

		} catch (SQLException ex) {
			Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

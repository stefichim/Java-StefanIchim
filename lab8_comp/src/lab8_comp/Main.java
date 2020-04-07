package lab8_comp;

import java.io.IOException;

import com.sun.jdi.connect.spi.Connection;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ArtistController artist1 = new ArtistController();
		ArtistController artist2 = new ArtistController();
		ArtistController artist3 = new ArtistController();
		
		artist1.findByName("Ichim");
		artist2.findByName("Popescu");
		artist3.findByName("Ionescu");
		
		
		AlbumController album1 = new AlbumController();
		AlbumController album2 = new AlbumController();
		AlbumController album3 = new AlbumController();
		
		album1.findByArtist(1);
		album2.findByArtist(2);
		album3.findByArtist(3);

		Connection myConn = (Connection) ConnectDB.getConnection();
		myConn.close();
	}

}

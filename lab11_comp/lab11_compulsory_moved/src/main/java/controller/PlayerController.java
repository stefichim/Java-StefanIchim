package controller;



import entity.Player;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import util.Database;

@RestController
@RequestMapping("/player")
public class PlayerController {
	private final List<Player> players = new ArrayList<>();

	@GetMapping
	public List<Player> getPlayers() {
		return players;
	}

	@GetMapping("/count")
	public int countPlayers() {
		return players.size();
	}

	@GetMapping("/{id}")
	public Player getPlayer(@PathVariable("id") int id) {
		return players.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}

	@PostMapping
	public int createPlayer(@RequestParam String name) {
		int id = 1 + players.size();
		players.add(new Player(id, name));
		return id;
	}

	@PostMapping(value = "/obj", consumes = "application/json")
	public ResponseEntity<String> createPlayer(@RequestBody Player player) {
		players.add(player);
		return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestParam String name) {
		Player player = findById(id);
		if (player == null) {
			return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND); // or GONE
		}
		player.setName(name);
		return new ResponseEntity<>("Product updated successsfully", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletePlayer(@PathVariable int id) {
		Player player = findById(id);
		if (player == null) {
			return new ResponseEntity<>("Product not found", HttpStatus.GONE);
		}
		players.remove(player);
		return new ResponseEntity<>("Product removed", HttpStatus.OK);
	}

	public Player findById(int id) {
		Player player = null;
		Connection conn = Database.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String s = "SELECT name FROM players WHERE id=" + "'" + id + "'";
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				String name = rs.getString("name"); // rs.getInt(1)
				player = new Player(id, name);
			}
			stmt.close();
			rs.close();

		} catch (SQLException ex) {
			Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return player;
	}

}
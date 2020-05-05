import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.management.ValueExp;

public class GameServer {

	// Define the port on which the server is listening
	public static final int PORT = 8102;

	public GameServer() throws IOException {

		Signal signal = new Signal();
		ServerSocket serverSocket = null;
		serverSocket = new ServerSocket(PORT);
		while (true) {
			try {

				serverSocket.setSoTimeout(10000);
				
				System.out.println("Waiting for a client ...");
				Socket socket = serverSocket.accept();
				// Execute the client's request in a new thread
				new ClientThread(socket, signal).start();
			} catch (IOException e) {
				System.err.println("Ooops... " + e);

			} finally {

				if (signal.isValue()) {
					serverSocket.close();
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		GameServer server = new GameServer();
		Signal signal = new Signal();
	}
}
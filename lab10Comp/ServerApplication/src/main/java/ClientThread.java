import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
	private Socket socket = null;
	private Signal signal;

	public ClientThread(Socket socket, 	Signal signal) {
		this.socket = socket;
		
		this.signal=signal;
	
	}

	public void run() {
		try {
			// Get the request from the input stream: client ->server
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String request = in.readLine();
			// Send the response to the output stream: server-> client
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			String raspuns;
			switch (request) {
			//case-uri pentru fiecare posibiltate: stop, exit sau orice comanda
			case "stop":
				raspuns = "Server stopped";
				out.println(raspuns);
				out.flush();
				
				signal.setValue(true); // setez semnalul pe true

				try {
					socket.close();
					System.exit(0); 
				} catch (IOException e) {
					System.err.println(e);
				}
			case "exit":
				raspuns = "Connection Closed";
				out.println(raspuns);
				out.flush();
				
				try {
					socket.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			default:
				raspuns = "Server received the request  " + request;
				break;
			}
			out.println(raspuns);
			out.flush();
		} catch (IOException e) {
			System.err.println("Communication error... " + e);
		} finally {
			try {
				socket.close(); 
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}
}

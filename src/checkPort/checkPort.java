package checkPort;
import java.net.*;
import java.io.*;

public class checkPort {
	public static void main (String[] args) {
		String hostName = "localhost";
		int portNumber = 135;
		try {
			System.out.println("Check port number: " + portNumber);
			Socket echoSocket = new Socket (hostName, portNumber);
			PrintWriter out = new PrintWriter (echoSocket.getOutputStream());
			BufferedReader in = new BufferedReader (new InputStreamReader(echoSocket.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			String userInput;
			System.out.println("Reading from port " + portNumber);
			while((userInput = stdIn.readLine()) != null) {
				out.println(userInput);
				System.out.println("echo: " + in.readLine());
			}
			out.close();
			in.close();
			stdIn.close();
			echoSocket.close();
			System.out.println("Socket closed");
			}
			catch (UnknownHostException e) {
				System.out.println("Unknown Host Exception occured" + e);
			}
			catch (IOException e) {}
		//}
	}
}

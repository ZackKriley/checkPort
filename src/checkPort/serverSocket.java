package checkPort;
import java.net.*;
import java.util.stream.Stream;
import java.io.*;

public class serverSocket {
		
    public static void main (String args[]) throws IOException {
    	ServerSocket s = new ServerSocket(1764);
    	Stream.generate(() -> {
    		try {
    			return s.accept();
    		}
    		catch(IOException e) {
    			e.printStackTrace();
    		}
    		return null;
    	}).forEach((skt) -> {
    		try {
    			Handler(skt);
    		}
    		catch(IOException e) {
    			e.printStackTrace();
    		}
    	});
    	s.close();
    }
    
    public static void Handler(Socket skt) throws IOException{
    	String data = "Connection";
    	System.out.println("Connection established.");
    	PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
    	out.print(data);
		System.out.println( new String(skt.getInputStream().readAllBytes()));
		skt.close();
    }
}
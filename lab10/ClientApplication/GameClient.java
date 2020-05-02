import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        Scanner scan= new Scanner(System.in);
        String mesaj;
        String mesajS="Server stopped";
        String exit1="exit";
        String response;
        int PORT = 8100; // The server's port
        try (

                Socket socket = new Socket(serverAddress, PORT);
                 ){
            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())) ;
            do{

                mesaj = scan.nextLine();
                out.println(mesaj);
                response = in.readLine();
                System.out.println(response);
            }while(!mesaj.equals(exit1)  && !response.equals(mesajS) );
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
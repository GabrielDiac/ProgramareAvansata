import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        String request=null;
        String stop1="stop";
        String mesajS="Server stopped";
        String mesajR="Server received the request ...";
        try {
            // Get the request from the input stream: client › server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            do {

                 request = in.readLine();
                 if(request==null)
                     break;
                 if(!request.equals(stop1))
                     out.println(mesajR);
                 else
                     out.println(mesajS);
                System.out.print(request);
                out.flush();
            }while(!request.equals(stop1));
            if(request!=null)
                 if(request.equals(stop1))
                  System.exit(0);
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}

package sendserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author hanhhoatranthi
 */
public class ServerThread implements Runnable {
    
    ServerSocket server;
    Server main;
    boolean keepGoing = true;
    
    public ServerThread(int port, Server main){
      //  main.appendMessage("[Server]: Máy Chủ hiện đang khởi động ở port "+ port);
        try {
            this.main = main;
            server = new ServerSocket(port);
            main.appendMessage("Máy Chủ Server đã khởi động.!");
        } 
        catch (IOException e) { main.appendMessage("[IOException]: "+ e.getMessage()); }
    }

    @Override
    public void run() {
        try {
            while(keepGoing){
                Socket socket = server.accept();

                /** SOcket thread **/
                new Thread(new SocketThread(socket, main)).start();
            }
        } catch (IOException e) {
            main.appendMessage("[ServerThreadIOException]: "+ e.getMessage());
        }
    }
    
    
    public void stop(){
        try {
            server.close();
            keepGoing = false;
            System.out.println("Máy Chủ bị đóng..!");
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}

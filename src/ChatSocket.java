import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by N.Petuhov on 16.03.2016.
 */
public class ChatSocket extends Thread {
    Socket socket;
    ChatServer chatServer;
    public ChatSocket(Socket socket, ChatServer chatServer){
        this.socket = socket;
        this.chatServer = chatServer;
    }
    @Override
    public void run(){
        try{
            //System.out.println("Just connected to "
            //+ socket.getRemoteSocketAddress());
            DataInputStream in =
                    new DataInputStream(socket.getInputStream());
            String message = in.readUTF();
            System.out.println(message);
            if(!message.equals("Bue.")) {
                DataOutputStream out =
                        new DataOutputStream(socket.getOutputStream());
                out.writeUTF(message);
                out.flush();
//                out.close();
            }
            else chatServer.close();
            in.close();
            socket.close();
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}

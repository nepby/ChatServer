import java.io.IOException;

/**
 * Created by N.Petuhov on 16.03.2016.
 */
public class Main {
    public static void main(String[] args){
        //int port = Integer.parseInt(args[0]);
        try
        {
            ChatServer server = new ChatServer(5050);
            server.start();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
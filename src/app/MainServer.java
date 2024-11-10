package app;

import java.io.IOException;

public class MainServer {
    public static void main(String[] args) {
        int port = 1234;
        String secretCode = "mySecretCode";

        GameServer server = new GameServer(port, secretCode);
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

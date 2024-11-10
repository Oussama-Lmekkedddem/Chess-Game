package  app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class GameClient {
    private String ipAddress;
    private int port;
    private String secretCode;
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public GameClient(String ipAddress, int port, String secretCode) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.secretCode = secretCode;
    }

    public void connect() throws IOException {
        socket = new Socket(ipAddress, port);
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());

        // Send secret code to server
        outputStream.writeObject(secretCode);
    }

    public void sendMove(PlayerMove move) throws IOException {
        outputStream.writeObject(move);
    }

    public PlayerMove receiveMove() throws IOException, ClassNotFoundException {
        return (PlayerMove) inputStream.readObject();
    }

    public void close() throws IOException {
        if (outputStream != null)
            outputStream.close();
        if (inputStream != null)
            inputStream.close();
        if (socket != null)
            socket.close();
    }
}


package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private int port;
    private String secretCode;
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public GameServer(int port, String secretCode) {
        this.port = port;
        this.secretCode = secretCode;
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Waiting for client connection...");
        socket = serverSocket.accept();
        System.out.println("Client connected");

        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());

        // Receive secret code from client
        String receivedCode;
        try {
            receivedCode = (String) inputStream.readObject();
            if (!receivedCode.equals(secretCode)) {
                System.err.println("Invalid secret code. Closing connection.");
                close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        if (serverSocket != null)
            serverSocket.close();
    }
}
